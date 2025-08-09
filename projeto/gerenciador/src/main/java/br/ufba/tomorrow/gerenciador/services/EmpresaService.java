package br.ufba.tomorrow.gerenciador.services;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.AtualizaEmpresaDTO;
import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.exceptions.NotFoundException;
import br.ufba.tomorrow.gerenciador.mappers.EmpresaMapper;
import br.ufba.tomorrow.gerenciador.mappers.UsuarioMapper;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.models.Usuario;
import br.ufba.tomorrow.gerenciador.output.EmpresaSaida;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;
import br.ufba.tomorrow.gerenciador.repositories.UsuarioRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Empresa salvar(CadastraEmpresaDTO cadastraEmpresaDTO) {
        Empresa empresa = EmpresaMapper.INSTANCE.cadastraEmpresaDTOParaEmpresa(cadastraEmpresaDTO);
        Usuario usuario = UsuarioMapper.INSTANCE.cadastraEmpresaDTOParaUsuario(cadastraEmpresaDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        empresa.setUsuario(usuario);        
        return empresaRepository.save(empresa);
    }

    public Empresa buscarPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public Long getCount() {
        return empresaRepository.count();
    }

    public List<EmpresaSaida> findAll() {
        return empresaRepository.findAll()
            .parallelStream()
            .map((empresa) -> EmpresaMapper.INSTANCE.paraEmpresaSaida(empresa))
            .toList();
    }

    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa update(Long id, AtualizaEmpresaDTO atualizaEmpresaDTO) {
        var empresaSalva = empresaRepository.findById(id).orElseThrow(() -> new NotFoundException());
        Empresa empresa = EmpresaMapper.INSTANCE.atualizaEmpresaDTOParaEmpresa(atualizaEmpresaDTO);
        empresaSalva.setNomeFantasia(empresa.getNomeFantasia());
        empresaSalva.setRazaoSocial(empresa.getRazaoSocial());
        empresaSalva.setCnpj(empresa.getCnpj());
        return empresaRepository.save(empresaSalva);
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}
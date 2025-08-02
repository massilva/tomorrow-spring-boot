package br.ufba.tomorrow.gerenciador.services;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufba.tomorrow.gerenciador.dtos.CadastraEmpresaDTO;
import br.ufba.tomorrow.gerenciador.mappers.EmpresaMapper;
import br.ufba.tomorrow.gerenciador.models.Empresa;
import br.ufba.tomorrow.gerenciador.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Empresa salvar(CadastraEmpresaDTO cadastraEmpresaDTO) {
        Empresa empresa = EmpresaMapper.INSTANCE.cadastraEmpresaDTOParaEmpresa(cadastraEmpresaDTO);
        empresa.setSenha(passwordEncoder.encode(empresa.getSenha()));
        return empresaRepository.save(empresa);
    }

    public Empresa buscarPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));
    }

    public Long getCount() {
        return empresaRepository.count();
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }
}
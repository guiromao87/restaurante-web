package br.com.guiromao.restaurante.service;

import br.com.guiromao.restaurante.model.dto.EnderecoJsonDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    public String getRua(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return new RestTemplate().getForObject(url, EnderecoJsonDto.class).getLogradouro();
    }
}

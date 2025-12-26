package etf.ip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.repository.ClientRepository;
import etf.ip.entity.*;

@Service
public class ClientService {
   
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void blockClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setBlocked(true);
        clientRepository.save(client);
    }

    public void unblockClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setBlocked(false);
        clientRepository.save(client);
    }
    
    public Optional<Client> getClientById (Long id)
	{
		return clientRepository.findById(id);
	}
}

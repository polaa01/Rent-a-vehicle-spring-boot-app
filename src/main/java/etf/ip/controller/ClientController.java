package etf.ip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.*;
import etf.ip.service.ClientService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/block/{id}")
    public void blockClient(@PathVariable Long id) {
        clientService.blockClient(id);
    }

    @PutMapping("/unblock/{id}")
    public void unblockClient(@PathVariable Long id) {
        clientService.unblockClient(id);
    }
    
    
    @GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id)
	{
		Optional<Client> client = clientService.getClientById(id);
		if(client.isPresent())
		{
			return ResponseEntity.ok(client.get());
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

}

package br.com.rocketseat.ApiRocketseat.controller;

import br.com.rocketseat.ApiRocketseat.model.User;
import br.com.rocketseat.ApiRocketseat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //usado quando a gente ta criando uma API, para obter retornos.
@RequestMapping("/api") //acessar nossa API
//http://localhost:8080/
public class UserController {
   // List<User> users = new ArrayList<User>();

    @Autowired //essa anotação permite que o spring gerenciar/instaciar o ciclo de vida da minha interface.
    private UserRepository userRepository;

    /*METÓDOS DE ACESSO DO HTTP
     * GET  - BUSCAR UMA INFORMEÇÃO DA NOSSA API
     * POST - ADICIONAR UM DADO/INF PRA NOSSA API
     * PUT - ATUALIZA UM DADO/INF PRA NOSSA API
     * DELETE - DELETA UM DADO/INF PRA NOSSA API
     * */

    //metódos (funcionalidade) de uma classe
   /*@PostMapping("/")
    public ResponseEntity<?> cadastrar(@RequestBody User user){
        users.add(user);
        System.out.println("User cadastrado com sucesso!");
        return new ResponseEntity<>(users, HttpStatus.CREATED);
   }*/
    @PostMapping("/")
    public ResponseEntity create (@RequestBody User user){
        //vou verificar se meu usuario ja existe
        var usuario = this.userRepository.findByUsername(user.getUsername());
        if(usuario!=null){
            //exibir mensagem de erro e status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe"); //pra quando meu usuario ja existir.
        }
        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

  /* @GetMapping("/users")
   public ResponseEntity<?> getUsers(){
       return new ResponseEntity<>(users, HttpStatus.OK);
   }*/
}

package br.com.rocketseat.ApiRocketseat.repository;

import br.com.rocketseat.ApiRocketseat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


//interface é um modelo ontem tem só as representações dos metodos e não implementações.
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username); //vai fazer um select na colunar username pra verificar se tem usuário igual.

}

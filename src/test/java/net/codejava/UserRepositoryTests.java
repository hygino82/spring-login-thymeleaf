package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.codejava.model.User;
import net.codejava.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void TestCreateUser() {
		User user = new User();
		user.setEmail("godofredo@gmail.com");
		user.setFirstname("Godofredo");
		user.setLastName("Juvenal");
		user.setPassword("godo2020");

		User savedUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, savedUser.getId());

		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}
}

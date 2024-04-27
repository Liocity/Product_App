package in.ashokit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.product;

public interface productrepo extends JpaRepository<product,Integer> {

}

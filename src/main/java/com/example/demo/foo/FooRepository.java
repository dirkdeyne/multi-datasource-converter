package com.example.demo.foo;

import org.springframework.data.repository.CrudRepository;

public interface FooRepository extends CrudRepository<Foo,Long> {
}

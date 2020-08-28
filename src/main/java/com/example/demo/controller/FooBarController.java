package com.example.demo.controller;

import com.example.demo.bar.Bar;
import com.example.demo.bar.BarRepository;
import com.example.demo.foo.Foo;
import com.example.demo.foo.FooRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FooBarController {

  private final FooRepository fooRepo;
  private final BarRepository barRepo;

  FooBarController(FooRepository fooRepo, BarRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init(){
    Foo foo = new Foo(1L,"foo","foo secret");
    Bar bar = new Bar(1L,"bar","bar secret");

    fooRepo.save(foo);
    barRepo.save(bar);

  }

  @GetMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    Foo foo = fooRepo.findById(id).orElseThrow();
    Bar bar = barRepo.findById(id).orElseThrow();

    return foo.getName() + " - " +  bar.getName();
  }

  @GetMapping("/foo/{id}")
  public Foo foo(@PathVariable("id") Long id) {
    return fooRepo.findById(id).orElseThrow();
  }

  @GetMapping("/bar/{id}")
  public Bar bar(@PathVariable("id") Long id) {
    return barRepo.findById(id).orElseThrow();
  }
}
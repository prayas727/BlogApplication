package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Post;

public interface PostRepo extends JpaRepository<Post,Integer> {

}

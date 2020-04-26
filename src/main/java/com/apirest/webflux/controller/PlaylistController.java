package com.apirest.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.services.PlaylistService;
import com.apirest.webfluxdocument.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/playlist")
	public Flux<Playlist> getPlaylist() {
		return playlistService.findAll();
	}
	
	@GetMapping("/playlist/{id}")
	public Mono<Playlist> getByIdPlaylist(@PathVariable String id) {
		return playlistService.findById(id);
	}
	
	@PostMapping(value="/playlis")
	public Mono<Playlist> save(@RequestBody Playlist playlist) {
		return playlistService.save(playlist);
	}
}
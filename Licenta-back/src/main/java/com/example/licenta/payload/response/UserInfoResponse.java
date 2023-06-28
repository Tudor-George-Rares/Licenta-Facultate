package com.example.licenta.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String email;
	private String nume;
	private String prenume;
	private String telefon;
	private String adresaCompleta;
	private List<String> roles;

	public UserInfoResponse(Long id, String username, String email, List<String> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
		this.adresaCompleta = adresaCompleta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getNume() {
		return nume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setAdresaCompleta(String adresaCompleta) {
		this.adresaCompleta = adresaCompleta;
	}

	public String getAdresaCompleta() {
		return adresaCompleta;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}

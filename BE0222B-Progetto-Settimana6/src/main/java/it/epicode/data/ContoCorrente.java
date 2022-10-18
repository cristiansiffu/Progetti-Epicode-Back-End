package it.epicode.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "contocorrente")
@Entity
public class ContoCorrente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String intestatario;
	private double saldo;
	
	public ContoCorrente() {}
	
	@Id
	public String getNumero() {
		return numero;
	}

	@Column(name = "intestatario", nullable = false, length = 50)
	public String getIntestatario() {
		return intestatario;
	}

	@Column(name = "saldo", nullable = false)
	public double getSaldo() {
		return saldo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}

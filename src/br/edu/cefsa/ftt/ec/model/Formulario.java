package br.edu.cefsa.ftt.ec.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formulario implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long id;
	
	String nomel;
	
	Date   data;
	
    float idade;
	
	
	public Formulario(Long id, String nome, String data, Float idade) {
		
		super();
		this.setId(id);
		this.setNome(nome);
		this.setData(data);
		this.setIdade(idade);
	}

	public Formulario(String id, String nome, String data, String idade) {
		
		super();
		this.setId(id);
		this.setNome(nome);
		this.setData(data);
		this.setIdade(Float.valueOf(idade));
	}

	public Formulario() { //Default constructor
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setId(String id) {
		if (id != null)
		   this.id = Long.valueOf(id);
		else
		   this.id = 0;
	}	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getData() {
		return this.data;
	}

	public void setData(String data) {
        
		//formato: 2018-09-20 mascara yyyy-MM-dd
		//formato: 20/09/2018 mascara dd/MM/yyyy
		//referencia: https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 

		try { 
			this.data = formatter.parse(data);
		} catch (Exception e) {
			System.err.println("Ops! Problema com a data: " + data);
			e.printStackTrace();
		} //try
		
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getIdade() {
		return this.idade;
	}

	public void setIdade(String idade) {
		this.idade = Float.valueOf(Idade);
	}
	
	public void setIdade(Float idade) {
		this.idade = idade;
	}

	
	@Override
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof Formulario) {

            return (this.getId() == ((Formulario) obj).getId());

        }  else {
        	
            return false;

        } //if

	} //equals
	
	@Override
    public String toString() {
        return "Formulario ["
                + "  id=" + this.id 
        		+ ", nome=" + this.nome
                + ", data=" + this.data 
                + ", idade=" + this.idade
                + "]";
    } //toString    
	
} //Formulario

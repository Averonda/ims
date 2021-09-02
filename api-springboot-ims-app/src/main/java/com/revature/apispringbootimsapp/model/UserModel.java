package com.revature.apispringbootimsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user", schema = "ims")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator" )
	@SequenceGenerator(name = "id_generator", sequenceName = "user_uid_seq", allocationSize = 1)
	private int uid;
	@Column
	private String username;
	@Column
	private String password;
	@Column(name = "permission_level")
	private String permissionLevel;
}
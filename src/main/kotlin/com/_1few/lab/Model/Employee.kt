package com._1few.lab.Model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Employee(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0L, val firstName: String = "", val lastName: String = "")
#language:pt
#coding: utf-8
@funcionais
Funcionalidade: Realizar cadastro
  de usuario randomico e registrar task.

  Contexto: Inicia aplicacao
    Dado que estou com o navegador aberto
    Quando preencho na barra de endereco o link "http://www.juliodelima.com.br/taskit/"

  Cenario: Realizer Cadastro
    E clico no botao 'OK I WANNA SIGN UP NOW'
    E preemcho o formulario no campo nome
    E preemcho o formulario no campo login
    Quando preemcho o formulario no campo password
    E clico no botao de 'SAVE'
    Entao na barra superior clico no link Logout

  Cenario: Realizar cadastro, fazer login e registrar uma task
    E clico no botao 'OK I WANNA SIGN UP NOW'
    E preemcho o formulario no campo nome
    E preemcho o formulario no campo login
    Quando preemcho o formulario no campo password
    E clico no botao de 'SAVE'
    Entao na barra superior clico no link Logout
    E clico no link da barra superior 'Sign in'
    E informo no formulario no campo 'login'
    E informo no formulario no campo 'password'
    Quando clico no botao 'SIGNIN'
    Dado que estou logado clico no botao '+ ADD A TASK'
    E preemcho no dialogo do campo title
    E seleciono a data de task 
    E o horario da task
    E preemcho no campo texto 'Tell us, please'
    Quando seleleciono o tipo done 
    Entao clico no botao 'SAVE'
      
    
    

    
    
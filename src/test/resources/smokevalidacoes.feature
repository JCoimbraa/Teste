# language: pt

@smokevalidacoes
Funcionalidade: Smoking Validacoes

  COMO assinante
  QUERO que ao cometer algum erro sistema critique
  PARA conseguir corrigir e prosseguir com compra

  Cenario: Informar Token invalido ao Recuperar senha na home
    Dado que acesso a home de "Avulso"
    E clico no link "Entrar"
    E clico no link "Esqueci minha senha"
    E informo dados na modal "Para recuperar sua senha"
    E informo dados na modal "Enviamos seu codigo"
    Entao sistema apresenta a mensagem "Validando Token"

  Cenario: Recuperar senha com token valido na home
    Dado que acesso a home de "Avulso"
    E clico no link "Entrar"
    E clico no link "Esqueci minha senha"
    E informo dados na modal "Para recuperar sua senha"
    E informo dados na modal "Enviamos seu codigo valido"
    Entao sou direcionato para tela "Area Logada"

  Cenario: Validar nome completo invalido no fluxo de adesao tela de cadastro
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    Então verifico que sistema apresenta mensagem "de validacao" e não habilita o botão cadastrar

  Cenario: Validar telefone inválido no fluxo de adesão tela de cadastro
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    Então verifico que sistema apresenta mensagem "de validacao telefone" e não habilita o botão cadastrar

  Cenario: Validar CNPJ inválido no fluxo de adesão tela de cadastro
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    Então verifico que sistema apresenta mensagem "de validacao cnpj" e não habilita o botão cadastrar

  Cenario: Validar E-mail inválido no fluxo de adesão tela de cadastro
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    Então verifico que sistema apresenta mensagem "de validacao email" e não habilita o botão cadastrar

  Cenario: Enviar Token Por email
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E clico no botão "Enviar codigo por email"
    Entao sistema apresenta em tela que email foi enviado

  Cenario: Informar Token invalido apos cadastro
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token"
    Entao sistema apresenta a mensagem "Validando Token Cadastro"

  Cenario: Validar nome completo invalido no fluxo de adesao tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Mensagem validando nome invalido"

  Cenario: Validar seu CPF invalido no fluxo de adesao tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Mensagem validando cpf invalido"

  Cenario: Validar Data de Nascimento invalida no fluxo de adesao tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Mensagem validando data de nascimento invalido"

  Cenario: Validar nome da mae invalido no fluxo de adesao tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Mensagem validando nome da mae invalido"

  Cenario: Validar Nome de um dos socios invalido no fluxo de adesao tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Mensagem validando nome do socio invalido"

  Cenario: Validar Senha que nao atende criterios
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    Entao Sistema me apresenta a "Sistema nao avanca tela"

  Cenario: Validar Numero do cartao incompleto no fluxo de adesao tela de pagamento
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta a "Mensagem validado cartao invalido"

  Cenario: Validar data de validade invalida no fluxo de adesao tela de pagamento
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta a "Mensagem validado data de validade invalida"

  Cenario: Validar Nome impresso no cartao invalido no fluxo de adesao tela de pagamento
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta a "Mensagem validado nome cartao invalido"

  Cenario: Validar obrigatoriedade de checkbox recorrencia plano assinatura
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao valido que o botão não esta habilitado para finalização sem ter salvo os dados do cartão

  Cenario: Validar obrigatoriedade de checkbox recorrencia plano avulso
    Dado que acesso a home de "Avulso"
    E clicar no plano de assinatura "140"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao valido que sistema habilita botão Finalizar mesmo sem clicar no checkbox de gravar cartão

  Cenario: Validar inexistencia de opçao de boleto no Plano Avulso 70
    Dado que acesso a home de "Avulso"
    E clicar no plano de assinatura "70"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    Entao valido que a opcao de boleto não existe

  Cenario: Validar CVV inválido no fluxo de adesão tela de pagamento
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta a "Mensagem validado CSS invalido"

  Cenario: Validar que ao nao informar token sistema nao direcione para tela de promote
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E nao informo Token
    Entao Sistema nao permite que eu feche tela de token enquanto nao informar o mesmo

  Cenario: Validar opcao boleto assinatura Simples
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "simples"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta opcao de boleto

  Cenario: Validar opcao boleto assinatura Essencial
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "essencial"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta opcao de boleto

  Cenario: Validar opcao boleto assinatura Premium
    Dado que acesso a home de "Assinatura"
    E clicar no plano de assinatura "premium"
    E informo dados na tela "Cadastro"
    E clico no botão "Cadastrar"
    E informo dados na tela "Token valido"
    E informo dados na tela "Promote"
    E clico no botão "Confirmar Cadastro"
    E informo dados na tela "Pagamento"
    Entao Sistema me apresenta opcao de boleto

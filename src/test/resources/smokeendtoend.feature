# language: pt

  @smokeendtoend
Funcionalidade: Smoking End to End

  COMO assinante
  QUERO concluir minhas compras
  PARA conseguir utilizar os serviços contratados

  Cenario: End to End Plano Simples Assinatura pagamento Cartao
    Dado que acesso a home "Assinatura"
    E clico no plano de assinatura "simples"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Assinatura"

  Cenario: End to End Plano Essencial Assinatura pagamento Cartao
    Dado que acesso a home "Assinatura"
    E clico no plano de assinatura "essencial"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Assinatura"

  Cenario: End to End Plano Premium Assinatura pagamento Cartao
    Dado que acesso a home "Assinatura"
    E clico no plano de assinatura "premium"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Assinatura"

  Cenario: End to End Plano Avulso 35 pagamento Cartao
    Dado que acesso a home "Avulso"
    E clico no plano de assinatura "35"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Avulso"

  Cenario: End to End Plano Avulso 70 pagamento Cartao
    Dado que acesso a home "Avulso"
    E clico no plano de assinatura "70"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Avulso"

  Cenario: End to End Plano Avulso 140 pagamento Cartao
    Dado que acesso a home "Avulso"
    E clico no plano de assinatura "140"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    Entao sistema conclui compra "Cartao Avulso"

  Cenario: End to End Plano Avulso 140 pagamento Boleto
    Dado que acesso a home "Avulso"
    E clico no plano de assinatura "140"
    E preencho os campos da tela "cadastro" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E clico na opcao "Boleto Bancario"
    E clico na opcao "Gerar Boleto"
    Entao Boleto é gerado com sucesso

  Cenario: End to End Plano Premium Assinatura CNPJ sem Endereco Cadastrado
    Dado que acesso a home "Assinatura"
    E clico no plano de assinatura "premium"
    E preencho os campos da tela "cadastro com CNPJ sem Endereco" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    E preencho os campos da tela "Endereco CNPJ" com dados válidos
    Entao sistema conclui compra "Cartao Assinatura"

  Cenario: End to End Plano Avulso CNPJ sem Endereco Cadastrado
    Dado que acesso a home "Avulso"
    E clico no plano de assinatura "140"
    E preencho os campos da tela "cadastro com CNPJ sem Endereco" com dados válidos
    E clico no botao "cadastrar"
    E preencho os campos da tela "Token"
    E clico no botao "Validar Token"
    E preencho os campos da tela "De Promote"
    E clico no botao "confirmar cadastro"
    E preencho os campos da tela "de Pagamento Assinatura" com dados válidos
    E clico no botao "finalizar"
    E preencho os campos da tela "Endereco CNPJ" com dados válidos
    Entao sistema conclui compra "Cartao Avulso"


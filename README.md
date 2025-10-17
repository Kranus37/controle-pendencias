# Sistema de Controle de Pendências

Este é um projeto simples de controle de pendências desenvolvido em Java com arquitetura MVC e persistência de dados em MySQL. O objetivo é demonstrar os conceitos fundamentais de Programação Orientada a Objetos, conexão com banco de dados e a estrutura MVC, conforme os requisitos de uma atividade acadêmica de Engenharia de Software.

## Requisitos

*   Java Development Kit (JDK) 8 ou superior
*   Apache Maven (para gerenciamento de dependências e build)
*   Servidor MySQL em execução
*   IntelliJ IDEA (IDE recomendada, mas pode ser usado NetBeans ou VS Code com plugins Java)

## Estrutura do Projeto (MVC)

O projeto segue a arquitetura Model-View-Controller, com os seguintes pacotes:

*   `model`: Contém as classes de domínio/entidades (ex: `Pendencia`).
*   `view`: Contém as classes de interface com o usuário (CLI - Command Line Interface) (ex: `PendenciaView`).
*   `controller`: Contém as classes que orquestram a lógica da aplicação, intermediando Model e View (ex: `PendenciaController`).
*   `dao` (Data Access Object): Contém as classes responsáveis pelo acesso e manipulação dos dados no banco de dados (ex: `PendenciaDAO`).
*   `util`: Contém classes utilitárias, como a de conexão com o banco de dados (ex: `DBConnection`).

## Funcionalidades (CRUD)

O sistema oferece as seguintes funcionalidades via interface de linha de comando (CLI) para a entidade `Pendencia`:

*   **Adicionar Pendência (Create):** Permite cadastrar uma nova pendência com descrição, data de criação, status e prioridade.
*   **Listar Pendências (Read):** Exibe todas as pendências cadastradas no sistema.
*   **Atualizar Pendência (Update):** Permite modificar os detalhes de uma pendência existente, buscando-a pelo ID.
*   **Deletar Pendência (Delete):** Permite remover uma pendência do sistema, buscando-a pelo ID.

## Diagrama de Entidade e Relacionamento (DER)

O sistema possui uma única entidade principal: `Pendencia`.

**Entidade: Pendencia**
*   `id` (INT, Chave Primária, Auto-incremento)
*   `descricao` (VARCHAR(255), NOT NULL)
*   `data_criacao` (DATE, NOT NULL)
*   `data_conclusao` (DATE, pode ser NULL)
*   `status` (VARCHAR(50), NOT NULL - ex: 'Pendente', 'Em Andamento', 'Concluída')
*   `prioridade` (VARCHAR(50), NOT NULL - ex: 'Baixa', 'Média', 'Alta')

**Relacionamentos:**
Neste projeto simplificado, não há relacionamentos complexos entre entidades, pois há apenas uma entidade principal. Se houvesse, seriam descritos aqui (ex: 1 para N, N para N).

## Documento de Visão (Escopo do Projeto)

### Problema a ser Resolvido

A dificuldade em organizar e acompanhar tarefas e compromissos diários, resultando em esquecimento de prazos e falta de priorização.

### Público-Alvo

Estudantes, profissionais autônomos e qualquer pessoa que precise de uma ferramenta simples para gerenciar suas tarefas e pendências pessoais ou de pequeno porte.

### Principais Funcionalidades

1.  **Registro e Visualização de Pendências:** Permitir ao usuário adicionar novas pendências com detalhes como descrição, data de criação, status e prioridade, e visualizar todas as pendências cadastradas.
2.  **Atualização de Status e Detalhes:** Possibilitar a edição de pendências existentes, incluindo a alteração de sua descrição, status (Pendente, Em Andamento, Concluída), data de conclusão e prioridade.
3.  **Remoção de Pendências:** Oferecer a funcionalidade de remover pendências que foram concluídas ou que não são mais relevantes.


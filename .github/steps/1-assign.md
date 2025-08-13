## Etapa 1: Habilite o agente de código Copilot

No exercício [Primeiros Passos com o GitHub Copilot](/skills/getting-started-with-github-copilot), aprendemos como usar o Copilot no editor de código para fazer grandes melhorias no site de Atividades Extracurriculares da Escola Mergington. 🎻 ⚽️ ♟️

Na verdade, o site se tornou uma ferramenta regular da escola. E, embora você goste dessa atenção, percebeu um problema! Você está prestes a sair de licença no próximo semestre!

Após conversar com a direção, eles aceitaram que novas funcionalidades podem esperar, mas... ficaram preocupados. É preciso ter _algo_ para lidar com pequenas mudanças enquanto você estiver ausente.

Vamos preparar os professores para o sucesso, cadastrando o Copilot (na nossa escola) para cuidar das atualizações enquanto estivermos fora.

<img width="600" alt="screenshot do WebApp da Escola Mergington" src="https://github.com/user-attachments/assets/6f5c59ab-398b-4fb0-8efd-0aa7b72fef97" />

### O Copilot agora é seu agente de código!

Em exercícios anteriores, usamos o Copilot em **chat**, **edições** e modo **agente**. Embora esses modos sejam úteis, o **agente de código Copilot** leva isso a outro nível, operando totalmente pelo GitHub. Não precisa de editor de código! 😎

| Recurso           | Copilot no editor             | Agente de código Copilot |
| ----------------- | ----------------------------- | ------------------------ |
| **Interface**     | Seu editor de código          | Issues e Pull Requests   |
| **Escopo**        | Arquivos locais               | Repositório              |
| **Ativação**      | Sugestões inline, chat        | Atribuição de issue      |
| **Customização**  | Instruções personalizadas     | Instruções personalizadas|
| **Suporte MCP**   | Sim                          | Sim                      |
| **Vibe Coding**   | 😎                            | 😎                       |

### Como funciona?

Do ponto de vista do colaborador, o fluxo é muito parecido com o de um projeto normal.

1. Um colaborador com **acesso de escrita** seleciona uma issue e a atribui ao Copilot (em vez de si mesmo).
2. O Copilot cria um branch e um pull request.
3. O Copilot trabalha no branch em um workflow do Actions e fornece atualizações na aba de conversas do pull request.
4. Quando o Copilot termina a issue, quem atribuiu é solicitado a revisar.
5. O responsável faz a revisão, adiciona comentários ou aprova.
6. Se houver feedback, o Copilot continua trabalhando para implementar as sugestões.
7. O solicitante repete os passos acima até ficar satisfeito e então faz o merge.

```mermaid
flowchart LR

    contributor((Colaborador))
    copilot((Copilot))
    reviewer((Revisor))

    issue@{ shape: notch-rect, label: "Issue" }
    repo@{ shape: cyl, label: "Repositório" }
    branch@{ shape: subproc, label: "Branch" }
    review@{ shape: diamond, label: "Revisão" }


    subgraph PR[Pull Request]
        direction TB
        branch
        review
        reviewer
    end


    %% Atribuir
    contributor gl1@-->|Seleciona| issue
    issue gl2@-->|Atribui para| copilot

    %% Trabalhar
    copilot pl1@-->|Cria| branch
    branch pl3@-->|Inicia| review

    %% Revisar
    reviewer gl3@-->|Fornece feedback| review
    review pl4@--> |Implementa feedback| branch

    %% Aprovado
    review gl4@-->|Aprova e faz merge| repo


    classDef users fill:#08872B,stroke:#5FED83,color:#fff
    classDef repo fill:#08872B,stroke:#5FED83,color:#fff
    classDef agent fill:#501DAF,stroke:#C06EFF,color:#fff
    classDef pr fill:#0969DA,stroke:#0349B4,color:#fff

    classDef green-line stroke:#08872B, stroke-width:4px;
    classDef purple-line stroke:#501DAF, stroke-width:4px;

    class contributor,reviewer users
    class copilot agent
    class repo repo

    class gl1,gl2,gl3,gl4 green-line
    class pl1,pl2,pl3,pl4 purple-line
```

### Isso é seguro?

Várias precauções de segurança foram implementadas para ajudar a reduzir preocupações. Aqui estão algumas limitações que você deve considerar ao pedir para o Copilot trabalhar em uma issue.

- O Copilot só pode fazer alterações no branch que ele criou e nos recursos fornecidos pelo repositório.
- O Copilot possui um [firewall configurável](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/customizing-copilot-coding-agents-development-environment#customizing-or-disabling-the-agents-firewall) que restringe o acesso à internet.
- Apenas usuários com acesso de escrita podem atribuir uma issue ao Copilot.
- Conteúdo oculto em issues (como código comentado) é ignorado.

> [!IMPORTANT]
> A lista completa de mitigações e configurações pode ser encontrada na documentação [Riscos e Mitigações](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/using-copilot-coding-agent#copilot-coding-agent-risks-and-mitigations).

## ⌨️ Atividade: (opcional) Conheça o site de atividades extracurriculares

> [!NOTE]
> Abrir um ambiente de desenvolvimento e rodar a aplicação não é necessário para completar este exercício. Você pode pular esta atividade se desejar.

<details>
<summary>Mostrar passos</summary>

Em outros exercícios, temos desenvolvido o site de Atividades Extracurriculares. Você pode seguir estes passos para iniciar o ambiente de desenvolvimento e experimentá-lo.

1. Clique com o botão direito do mouse no botão abaixo para abrir a página **Criar Codespace** em uma nova aba. Use a configuração padrão.

   [![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/{{full_repo_name}}?quickstart=1)

1. Aguarde um tempo para o ambiente ser preparado. Ele instalará automaticamente todos os requisitos e serviços.

1. Valide se as extensões **GitHub Copilot** e **Java** estão instaladas e habilitadas.

   <img width="300" alt="copilot extension for VS Code" src="https://github.com/user-attachments/assets/ef1ef984-17fc-4b20-a9a6-65a866def468" /><br/>

1. Tente executar a aplicação. Na barra lateral esquerda, selecione a aba **Run and Debug** e clique no ícone **Iniciar Depuração**.

   <details>
   <summary>📸 Mostrar captura de tela</summary><br/>

   <img width="300" alt="run and debug" src="https://github.com/user-attachments/assets/50b27f2a-5eab-4827-9343-ab5bce62357e" />

   </details>

   <details>
   <summary>🤷 Tendo problemas?</summary><br/>

   Se a área **Run and Debug** estiver vazia, tente recarregar o VS Code: Abra a paleta de comandos (`Ctrl`+`Shift`+`P`) e procure por `Developer: Reload Window`.

   <img width="300" alt="empty run and debug panel" src="https://github.com/user-attachments/assets/0dbf1407-3a97-401a-a630-f462697082d6" />

   </details>

1. Use a aba **Ports** para encontrar o endereço da página da web, abri-la e verificar se está em execução.

   <details>
   <summary>📸 Mostrar captura de tela</summary><br/>

   <img width="350" alt="ports tab" src="https://github.com/user-attachments/assets/8d24d6b5-202d-4109-8174-2f0d1e4d8d44" />

   </details>

</details>

## ⌨️ Atividade: Habilite o agente de codificação Copilot em seu repositório

Antes de começarmos a delegar solicitações dos professores para o Copilot, precisamos conceder acesso ao nosso repositório.

1. No canto superior direito, clique em seu **ícone de usuário** e selecione **Configurações**.

   <img width="300" src="https://github.com/user-attachments/assets/7f8c3602-6de2-4c75-8047-8f4853495f46"><br/>
   <img width="300" src="https://github.com/user-attachments/assets/2aedfd6e-8b9f-40bb-bdf9-c9fd597f94a4">

1. Na navegação à esquerda, expanda a seção **Copilot** e selecione **Agente de codificação**.

   <img width="300" src="https://github.com/user-attachments/assets/79800990-6d5c-4055-acc9-b15734fe8b80">

1. Altere o campo **Acesso ao repositório** para `Apenas repositórios selecionados`.

   <img width="300" src="https://github.com/user-attachments/assets/7a665042-b064-4baf-a7e7-0dfc0261063e">

1. Clique no botão **Selecionar repositórios** e verifique se este exercício está selecionado.

   <img width="300" src="https://github.com/user-attachments/assets/4bec16dc-7b52-4e95-b554-47252b622adb">

## ⌨️ Atividade: Atribua uma issue ao Copilot

Existem várias issues importantes para serem resolvidas antes de sairmos, mas vamos fazer um teste em uma das opções mais simples primeiro. Isso nos permitirá ver como funcionam as interações e a colaboração, para que possamos atualizar nossa documentação para orientar os outros professores. A maioria não sabe como usar um editor de código tradicional!

> [!TIP]
> Tente deixar o objetivo e os critérios de aceitação de uma issue claros. Além disso, dividir tarefas grandes em tarefas menores oferece mais oportunidades de feedback!

1. Volte para o [repositório do exercício](<(https://github.com/{{full_repo_name}})>).

1. Na navegação superior, selecione a aba **Issues**.

1. Acima da lista, no canto superior direito, clique no botão **Nova Issue**.

1. Defina o **Título** como:

   ```md
   Atividade Ausente: Manga Maniacs
   ```

   Insira o texto abaixo como descrição e clique no botão **Criar**.

   ```md
   O clube de mangá foi recentemente anunciado e, naturalmente, está faltando no site. Por favor, adicione-o.

   Aqui estão os detalhes:

   Descrição: Explore as histórias fantásticas dos personagens mais interessantes dos Mangás japoneses (romances gráficos).

   Horário: Terças-feiras às 19h
   Máximo de participantes: 15 pessoas
   ```

1. No canto superior direito, clique na área **Atribuídos a** e selecione **Copilot**.

   <img width="350" src="https://github.com/user-attachments/assets/444f9432-17c3-4466-bb8e-aa4e44238130" />

1. Na parte inferior, clique no botão **Criar**. Após um momento, você notará:

   - A issue terá uma reação `👀` para mostrar que o Copilot está lendo a issue.
   - O registro de atividades mostra que você atribuiu a issue ao Copilot.
   - O registro de issues inclui um pull request vinculado.

   <img width="350" src="https://github.com/user-attachments/assets/40245540-e717-43b3-b2be-90f25cc494d0" />

1. Com a issue atribuída, Mona deve estar ocupada verificando seu trabalho. Dê a ela um momento para compartilhar os próximos passos.

<details>
   <summary>Tendo problemas? 🤷</summary><br/>

Se você não receber feedback, aqui estão algumas coisas para verificar:

- Certifique-se de que você atribuiu a issue correta. Se você praticar em outras issues, elas serão ignoradas.

</details>

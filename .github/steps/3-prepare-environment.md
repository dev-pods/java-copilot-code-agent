## Etapa 3: Preparando o ambiente do Copilot

Vamos adicionar informações sobre a escola, papéis a serem assumidos, tarefas típicas dos professores e um ambiente de desenvolvimento pré-configurado para tornar tudo mais rápido e confiável (assim a equipe de TI não se preocupa com o uso de minutos do Actions).

- **instruções do copilot** – Forneça contexto específico do projeto para o Copilot antes de considerar a issue.
  - Inclua considerações de negócio para o desenvolvimento do projeto.
  - Defina papéis para orientar o Copilot.
  - Adicione comandos úteis para tarefas comuns.
- **passos de configuração do copilot** – Customize o ambiente de desenvolvimento antecipadamente para tornar as sessões mais rápidas.
  - Pré-instale ferramentas úteis para o Copilot.
  - Reduza erros de instalação de versões incorretas.
- **ambiente** – Use ambientes do repositório para configurações.
  - Forneça variáveis para ajustar deploys em diferentes ambientes.
  - Adicione segredos para acessar recursos adicionais.

> [!DICA]
> Você também pode [habilitar um servidor Model Context Protocol (MCP)](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/extending-copilot-coding-agent-with-model-context-protocol) para dar ainda mais funcionalidades ao Copilot!

### ⌨️ Atividade: Crie instruções para guiar o Copilot

1. No menu superior, selecione a aba **Code**.

1. Crie um novo branch chamado `prepare-environment`.

   <img width="250" alt="imagem" src="https://github.com/user-attachments/assets/c48deded-4214-4edd-9a50-d1368bfb12e8" />

1. Navegue até o arquivo `.github/copilot-instructions.md` e edite-o.

1. Substitua o texto de exemplo por um link para o guia de desenvolvimento.

   ```md
   ## Ambiente de Desenvolvimento

   Para instruções detalhadas de configuração e desenvolvimento, consulte nosso [Guia de Desenvolvimento](../docs/how-to-develop.md).
   ```

1. Adicione informações extras sobre a escola e os professores para ajudar o Copilot a interagir de forma mais natural.

   ```md
   ### Interação com Usuários

   Considere o seguinte ao se comunicar com a equipe:

   - Os professores não são técnicos. Explique de forma simples e evite jargões de software.
   - Qualquer novo código deve ser fácil de manter e entender, mesmo sem experiência em programação.

   ## Arquitetura do Programa

   - Os usuários do site são alunos e professores. Garanta uma experiência simples.
   - Não crie apps ou serviços adicionais.
   - Não crie ferramentas de linha de comando.
   - Não faça uma aplicação longa em um único arquivo. Sempre use uma estrutura de diretórios fácil de entender.
   - Use apenas HTML, CSS, Javascript e Python. Não utilize outras linguagens.
   ```

   > 💡 Dica: Você pode adicionar mais detalhes. Veja o arquivo `copilot-instructions-ext.md` para ideias.

1. Ao terminar, **faça commit das alterações** no branch `prepare-environment`.

### ⌨️ Atividade: Prepare o ambiente de codificação para o Copilot

A personalização do ambiente de desenvolvimento do Copilot e o ajuste das [permissões](https://docs.github.com/en/actions/writing-workflows/choosing-what-your-workflow-does/controlling-permissions-for-github_token) são feitos com um workflow exclusivo do [GitHub Actions](https://github.com/features/actions). Para todas as opções de configuração, veja a documentação sobre [pré-instalação de dependências para o Copilot](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/customizing-copilot-coding-agents-development-environment#pre-installing-tools-or-dependencies-in-copilots-environment).

1. Certifique-se de que você ainda está no branch `prepare-environment`.

1. Navegue até o diretório `.github/workflows/`.

1. No canto superior direito, clique no botão **Adicionar arquivo** e selecione **Criar novo arquivo**.

   <img width="250" alt="imagem" src="https://github.com/user-attachments/assets/c135dd3f-72bd-4d2b-b21f-9c4968a06f5f" />

1. Defina o nome do arquivo como `copilot-setup-steps.yml`.

   <img width="650" alt="imagem" src="https://github.com/user-attachments/assets/ac615290-1045-45a5-8201-637721ef6fd2" />

1. Cole a configuração de workflow abaixo, que irá pré-instalar as dependências do backend Python do site.

   ```yml
   name: "Copilot Setup Steps"

   on: workflow_dispatch
   jobs:
     # Este é o nome de job obrigatório. Se for diferente, o Copilot irá ignorar.
     copilot-setup-steps:
       runs-on: ubuntu-latest

       # Concede acesso antecipado ao Copilot para ler o conteúdo do repositório.
       permissions:
         contents: read

       steps:
         - name: Fazer checkout do código
           uses: actions/checkout@v4

         - name: Configurar Python
           uses: actions/setup-python@v4
           with:
             python-version: "3.x"
             cache: "pip"

         - name: Instalar dependências Python
           run: |
             python -m pip install --upgrade pip
             pip install -r src/requirements.txt
   ```

   > 🪧 **Nota:** O Copilot irá buscar automaticamente o conteúdo do repositório depois. Este workflow fornece acesso antecipado durante a configuração para instalar as dependências.

   > 🪧 **Nota:** O Copilot irá identificar e instalar dependências ausentes automaticamente. Fazer isso agora economiza tempo do Copilot e garante a configuração correta do ambiente.

1. No canto superior direito, clique no botão **Commit changes...** e faça commit das alterações no branch `prepare-environment`.

1. Crie um **pull request**, mas **NÃO** faça o merge ainda. A Mona irá verificar seus arquivos para confirmar se estão corretos.

1. Depois que a Mona compartilhar os próximos passos, você pode fazer o merge do pull request.

> 🙋 **Pergunta:** Como foi o processo manual comparado a deixar o Copilot fazer a maior parte do trabalho? 🤔

<details>
<summary>🤷 Está com problemas?</summary><br/>

Se você acidentalmente fez o merge do pull request antes da Mona compartilhar o feedback sobre erros, tudo bem. Basta recriar o branch e tentar novamente com um novo pull request.

</details>
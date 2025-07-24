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

Customizing Copilot's development environment and adjusting [permissions](https://docs.github.com/en/actions/writing-workflows/choosing-what-your-workflow-does/controlling-permissions-for-github_token) is done with a unique [GitHub Actions](https://github.com/features/actions) workflow. For all configuration options, see the [pre-installing dependencies for Copilot](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/customizing-copilot-coding-agents-development-environment#pre-installing-tools-or-dependencies-in-copilots-environment) documentation.

1. Ensure you are still on the `prepare-environment` branch.

1. Navigate to the `.github/workflows/` directory.

1. In the top right, click the **Add file** button and select **Create new file**.

   <img width="250" alt="image" src="https://github.com/user-attachments/assets/c135dd3f-72bd-4d2b-b21f-9c4968a06f5f" />

1. Set the file name to `copilot-setup-steps.yml`.

   <img width="650" alt="image" src="https://github.com/user-attachments/assets/ac615290-1045-45a5-8201-637721ef6fd2" />

1. Paste the following workflow configuration, which will pre-install the dependencies for the website's Python backend.

   ```yml
   name: "Copilot Setup Steps"

   on: workflow_dispatch
   jobs:
     # This is the required job name. If different, Copilot will ignore it.
     copilot-setup-steps:
       runs-on: ubuntu-latest

       # Grant Copilot early access to read the repository content.
       permissions:
         contents: read

       steps:
         - name: Checkout code
           uses: actions/checkout@v4

         - name: Set up Python
           uses: actions/setup-python@v4
           with:
             python-version: "3.x"
             cache: "pip"

         - name: Install Python dependencies
           run: |
             python -m pip install --upgrade pip
             pip install -r src/requirements.txt
   ```

   > 🪧 **Note:** Copilot will automatically retrieve the repository contents later. This workflow provides early access during setup to install the dependencies.

   > 🪧 **Note:** Copilot will automatically identify and install missing dependencies. Doing it now saves Copilot time and ensures proper environment setup

1. In the top right, click the **Commit changes...** button and commit your changes to the `prepare-environment` branch.

1. Create a **pull request**, but do **NOT** merge it yet. Mona will check your files to confirm they are correct.

1. After Mona shares the next steps, you can merge the pull request.

> 🙋 **Question:** How did the manual process feel compared to letting Copilot do most of the work? 🤔


<details>
<summary>🤷 Having trouble?</summary><br/>

If you accidentally merged the pull request before Mona shared feedback about mistakes, that is ok. Just recreate the branch and try again with a new pull request.

</details>
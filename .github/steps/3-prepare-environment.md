## Etapa 3: Preparando o ambiente do GitHub Copilot Coding Agent

O GitHub Copilot Coding Agent é um assistente de IA avançado que pode executar tarefas complexas de desenvolvimento automaticamente. Para maximizar sua eficácia, precisamos configurar dois arquivos essenciais que personalizam seu comportamento e ambiente de trabalho.

### Configuração do GitHub Copilot Coding Agent

O GitHub Copilot Coding Agent funciona diferente do Copilot tradicional - ele não apenas sugere código, mas pode:
- **Executar comandos e workflows completos** de desenvolvimento
- **Analisar e modificar múltiplos arquivos** simultaneamente  
- **Executar testes e validações** automaticamente
- **Interagir com APIs e serviços externos** conforme necessário
- **Criar documentação e relatórios** detalhados sobre as mudanças

Para que o agent funcione eficientemente, precisamos configurar:

#### 1. **Instruções do Copilot** (`.github/copilot-instructions.md`)
Este arquivo fornece contexto específico do projeto para orientar o comportamento do agent:
- **Contexto de negócio**: Informações sobre a escola, usuários e objetivos
- **Padrões arquiteturais**: Como o código deve ser estruturado (Clean Architecture)
- **Convenções de desenvolvimento**: Padrões de nomenclatura, validação e testes
- **Comandos úteis**: Scripts e workflows comuns do projeto

#### 2. **Passos de Configuração** (`.github/workflows/copilot-setup-steps.yml`)
Este workflow GitHub Actions pré-configura o ambiente de desenvolvimento:
- **Pré-instala dependências**: Java 21, Maven, MongoDB
- **Configura cache**: Para acelerar compilações futuras
- **Define variáveis de ambiente**: Profiles e configurações necessárias
- **Valida o ambiente**: Garante que tudo está funcionando antes do agent iniciar

### Benefícios desta Configuração

- **Velocidade**: Agent não perde tempo instalando ferramentas básicas
- **Consistência**: Ambiente padronizado evita erros de configuração  
- **Contexto**: Agent entende melhor o projeto e toma decisões mais precisas
- **Eficiência**: Reduz uso de minutos do GitHub Actions e melhora performance

> [!TIP]
> Você também pode [habilitar um servidor Model Context Protocol (MCP)](https://docs.github.com/en/enterprise-cloud@latest/early-access/copilot/coding-agent/extending-copilot-coding-agent-with-model-context-protocol) para dar ainda mais funcionalidades ao Copilot!

### 📚 Documentação Oficial e Links Úteis

Para aprofundar seu conhecimento sobre o GitHub Copilot Coding Agent, consulte estes recursos oficiais:

#### 📖 Documentação Principal
- [**Sobre o GitHub Copilot Coding Agent**](https://docs.github.com/copilot/concepts/about-copilot-coding-agent) - Visão geral completa, benefícios, segurança e limitações
- [**Como usar o Copilot para trabalhar em issues**](https://docs.github.com/en/copilot/using-github-copilot/coding-agent/using-copilot-to-work-on-an-issue) - Guia passo a passo para atribuir issues ao Copilot
- [**Personalizando o ambiente de desenvolvimento**](https://docs.github.com/copilot/how-tos/agents/copilot-coding-agent/customizing-the-development-environment-for-copilot-coding-agent) - Como configurar dependências e variáveis de ambiente

#### 🏆 Melhores Práticas
- [**Boas práticas para usar o Copilot em tarefas**](https://docs.github.com/en/copilot/tutorials/coding-agent/best-practices) - Como escrever issues eficazes e escolher tarefas adequadas
- [**Uso responsável do Copilot Coding Agent**](https://docs.github.com/en/copilot/responsible-use-of-github-copilot-features/responsible-use-of-copilot-coding-agent-on-githubcom) - Diretrizes de segurança e ética

#### 🔧 Configuração e Personalização
- [**Adicionando instruções personalizadas**](https://docs.github.com/en/copilot/customizing-copilot/adding-repository-custom-instructions-for-github-copilot) - Como criar arquivos `.github/copilot-instructions.md`
- [**Habilitando o Copilot Coding Agent**](https://docs.github.com/en/copilot/concepts/coding-agent/enable-coding-agent) - Requisitos e processo de ativação
- [**Estendendo com Model Context Protocol (MCP)**](https://docs.github.com/en/copilot/using-github-copilot/coding-agent/extending-copilot-coding-agent-with-mcp) - Funcionalidades avançadas

#### 🎯 Hands-on e Prática
- [**Exercício: Expand your team with Copilot**](https://github.com/skills/expand-your-team-with-copilot/) - Prática guiada oficial do GitHub Skills
- [**Monitorando sessões do Copilot**](https://docs.github.com/en/copilot/how-tos/agents/copilot-coding-agent/tracking-copilots-sessions) - Como acompanhar o progresso em tempo real

#### 🏢 Para Organizações
- [**Pilotando o Copilot Coding Agent na organização**](https://docs.github.com/en/copilot/tutorials/coding-agent/pilot-coding-agent) - Guia para implantação empresarial
- [**Usando efetivamente na organização**](https://docs.github.com/pt/copilot/rolling-out-github-copilot-at-scale/enabling-developers/using-copilot-coding-agent-in-org) - Estratégias de adoção

#### ⚙️ Referências Técnicas
- [**Sintaxe de workflows do GitHub Actions**](https://docs.github.com/en/actions/using-workflows/workflow-syntax-for-github-actions) - Para customizar `copilot-setup-steps.yml`
- [**Permissões do GITHUB_TOKEN**](https://docs.github.com/en/actions/writing-workflows/choosing-what-your-workflow-does/controlling-permissions-for-github_token) - Configuração de segurança
- [**GitHub Copilot Trust Center**](https://copilot.github.trust.page/) - Informações sobre privacidade e segurança

> 💡 **Dica**: Marque estes links como favoritos! Eles serão úteis durante toda sua jornada com o GitHub Copilot Coding Agent.

### ⌨️ Atividade: Configure as instruções do GitHub Copilot Agent

O arquivo `.github/copilot-instructions.md` já existe no repositório e contém as diretrizes arquiteturais do projeto. Você precisa estudar e marcar que entendeu o conteúdo.

1. No menu superior, selecione a aba **Code**.

1. Crie um novo branch chamado `prepare-environment`.

   <img width="250" alt="imagem" src="https://github.com/user-attachments/assets/c48deded-4214-4edd-9a50-d1368bfb12e8" />

1. Navegue até o arquivo `.github/copilot-instructions.md` e estude seu conteúdo.

1. **Leia atentamente** todas as seções do arquivo, especialmente:
   - **Architecture Overview**: Como o projeto usa Clean Architecture
   - **Critical Development Patterns**: Padrões de validação, repositórios e casos de uso
   - **Essential Commands & Workflows**: Comandos Maven e configuração do ambiente
   - **Key Technical Decisions**: Decisões sobre segurança, testes e integração

1. **Marque a caixa de seleção** no início do arquivo para confirmar que entendeu:

   ```md
   [X] - Aprendi sobre como configurar o copilot-instructions.
   ```
   
   > ⚠️ **Importante**: Troque `[ ]` por `[X]` para marcar a caixa como concluída.

1. **Opcional**: Se desejar, pode adicionar informações extras sobre interação com usuários:

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
   - Use apenas HTML, CSS, Javascript e Java. Não utilize outras linguagens.
   ```

1. **Faça commit das alterações** no branch `prepare-environment`.

### ⌨️ Atividade: Configure o ambiente de desenvolvimento para o GitHub Copilot Agent

O arquivo `copilot-setup-steps.yml` já existe e contém a configuração do ambiente. Você precisa estudar e marcar que entendeu como configurá-lo.

> **Como funciona**: Este workflow GitHub Actions é executado **antes** do Copilot Agent iniciar, preparando um ambiente completo com Java 21, Maven e MongoDB. Isso economiza tempo e garante consistência.

1. Certifique-se de que você ainda está no branch `prepare-environment`.

1. Navegue até o arquivo `.github/workflows/copilot-setup-steps.yml` e **estude seu conteúdo detalhadamente**.

1. **Analise cada seção do workflow**:

   - **Nome e trigger**: Como o workflow é identificado e quando executa
   - **Job obrigatório**: Por que o job deve se chamar `copilot-setup-steps`
   - **Permissões**: Quais acessos o workflow precisa 
   - **Steps de configuração**: Como Java, MongoDB e dependências são instaladas
   - **Verificações**: Como o ambiente é validado antes do Agent iniciar

1. **Marque a caixa de seleção** no início do arquivo para confirmar que entendeu:

   ```yml
   # [X] - Aprendi sobre como configurar o copilot-setup-steps.
   ```
   
   > ⚠️ **Importante**: Troque `[ ]` por `[X]` para marcar a caixa como concluída.

1. **Teste o workflow** (opcional):
   - Vá para a aba **Actions** do repositório
   - Clique em "Copilot Setup Steps" 
   - Clique em "Run workflow" para executar manualmente
   - Observe como o ambiente é configurado

1. **Faça commit das alterações** no branch `prepare-environment`.

#### Por que essa configuração é importante?

- **Performance**: Agent não precisa instalar Java/Maven a cada execução
- **Reliability**: Versões específicas garantem comportamento consistente  
- **Cost-efficiency**: Reduz uso de minutos do GitHub Actions
- **Developer Experience**: Agent pode focar no código, não na infraestrutura

#### Elementos-chave do workflow:

| Elemento | Propósito |
|----------|-----------|
| `workflow_dispatch` | Permite execução manual para testes |
| `copilot-setup-steps` | Nome obrigatório do job |
| `contents: read` | Permissão mínima necessária |
| `setup-java@v4` | Instala Java 21 com cache Maven |
| `mongodb-github-action` | Configura MongoDB para desenvolvimento |
| `continue-on-error: true` | Evita falhas em steps não-críticos |

### 🎯 Finalizando a Etapa 3

1. Crie um **pull request** do branch `prepare-environment` para `main`, mas **NÃO** faça o merge ainda.

2. O workflow de validação irá verificar se:
   - [X] Você marcou a caixa de entendimento no arquivo `copilot-instructions.md`
   - [X] Você marcou a caixa de entendimento no arquivo `copilot-setup-steps.yml`

3. **Aguarde a Mona** verificar seus arquivos e fornecer feedback.

4. Depois que a Mona confirmar que tudo está correto, você pode fazer o **merge** do pull request.

### 🤔 Reflexão

> **Pergunta**: Como foi o processo de configuração manual comparado a deixar o GitHub Copilot Agent fazer a maior parte do trabalho automaticamente?

**Benefícios da configuração prévia**:
- ✅ **Controle total** sobre o ambiente e dependências
- ✅ **Documentação clara** dos requisitos do projeto  
- ✅ **Reutilização** da configuração em diferentes sessões
- ✅ **Redução de erros** por configuração inconsistente

**Próximos passos**: Na etapa 4, você verá o GitHub Copilot Agent em ação usando essas configurações!

---

<details>
<summary>🤷 Está com problemas?</summary>

Se você acidentalmente fez o merge do pull request antes da Mona fornecer feedback, tudo bem! Você pode:

1. Recriar o branch `prepare-environment` 
2. Fazer as correções necessárias
3. Criar um novo pull request

O importante é garantir que ambas as caixas de seleção estejam marcadas nos arquivos corretos.

</details>
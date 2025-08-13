## Etapa 2: Colabore com o Copilot

Quando o Copilot cria um pull request, você encontrará:

- **Descrição do Pull Request** – O Copilot mantém um resumo conciso do objetivo e da implementação.
- **Linha do tempo** – O Copilot fornece notas de alto nível sobre sessões de trabalho e commits.
- **Histórico de Sessões** – Um registro detalhado dos passos que o Copilot seguiu para implementar a issue.

Você pode dar feedback ao Copilot da mesma forma que faria com um colega. Essas ações fazem o Copilot iniciar uma nova sessão de trabalho.

- **Comentários** – Adicione um comentário na conversa do pull request.
- **Revisões** – Combine vários comentários em uma revisão de pull request.
- **@ menções** – Você pode marcar o Copilot em um comentário como faria com um colega.

#### Considerações importantes

- O trabalho do Copilot é feito em um branch com o padrão `copilot/*` e ele não tem acesso a outros branches.
- O Copilot não pode acionar workflows do Actions.
  - Workflows disparados em pull requests precisam de aprovação humana para rodar.
- Regras e proteções do repositório continuam valendo normalmente.

> [!TIP]
> Todo trabalho criado pelo Copilot é commitado com o responsável como co-contribuidor (mantendo seu gráfico de contribuições seguro). 💕

### ⌨️ Atividade: Veja o progresso do Copilot

1. Na issue, clique no link de referência para o pull request. Alternativamente, use a aba **Pull Requests** no topo.

1. Veja em tempo real o Copilot atualizando a descrição do pull request. Ele passa por 3 fases:

   <details>
      <summary>1. Ao iniciar, o Copilot copia a issue inicial. <b>[mostrar imagem]</b></summary>
      <img width="500" alt="imagem" src="https://github.com/user-attachments/assets/967dbea0-01c2-4531-9bce-5a055d3dad25" />
   </details>

   <details>
      <summary>2. Após o planejamento, o Copilot fornece uma lista de ações. <b>[mostrar imagem]</b></summary>
      <img width="500" alt="imagem" src="https://github.com/user-attachments/assets/acadb796-6545-4b6d-b2b3-9a00ea1744a2" />
   </details>

   <details>
      <summary>3. Ao finalizar, o Copilot fornece um resumo. <b>[mostrar imagem]</b></summary>
      <img width="500" alt="imagem" src="https://github.com/user-attachments/assets/61204574-0262-4c2f-af4b-09b284f31b90" />
   </details>

1. Role a página para ver a linha do tempo e as notas do Copilot. Clique no botão **View session**.

   <img width="500" src="https://github.com/user-attachments/assets/088260e6-bae0-40af-8186-864eb3e7b8a2" />

1. A nova página mostra um diário do trabalho do Copilot. A navegação à esquerda lista cada sessão de trabalho.

   <img width="500" src="https://github.com/user-attachments/assets/2c80fa91-1123-4813-a801-42af368240b9" />

1. Se necessário, aguarde o Copilot terminar as alterações.

> [!TIP]
> Você pode usar o menu **edited** para ver o histórico de alterações da descrição do pull request.
>
> <details>
> <summary>Mostrar imagem</summary>
> <img width="500" alt="image" src="https://github.com/user-attachments/assets/cb88a67c-e42f-463c-88cd-b23a391b28a0" />
> </details>

### ⌨️ Atividade: Dê feedback ao Copilot

1. De volta ao pull request, clique no botão **Adicionar sua revisão**.

   <img width="350" src="https://github.com/user-attachments/assets/d71847b9-573b-451e-9c85-946a6988e3f0" />

1. Encontre a nova entrada criada pelo Copilot. Passe o mouse sobre uma linha para mostrar o sinal de mais. **Clique** para abrir a caixa de diálogo de comentário.

   <img width="350" src="https://github.com/user-attachments/assets/fd1375a4-fbdf-453e-a457-7bcb1fbbea23" />

1. Lendo a descrição, achamos que ela deveria ser mais interessante para combinar com o espírito dos Mangás. Vamos pedir ao Copilot para melhorar isso. Insira o texto abaixo e clique em **Iniciar revisão**.

   ```md
   Por favor, altere esta descrição para ser inspirada nos Mangás japoneses.
   Precisa de mais personalidade para atrair os estudantes.
   ```

   <img width="350" src="https://github.com/user-attachments/assets/f37da948-2062-4f46-ba75-bcff538800e4" />

1. No topo da lista de alterações, clique no botão **Finalizar sua revisão** e selecione **Enviar revisão**.

1. Após alguns instantes, o Copilot adicionará uma nova entrada de sessão e indicará o progresso na linha do tempo.

1. Aguarde o Copilot terminar a alteração e então clique no botão **Ver alterações** para ver a descrição da atividade atualizada.

   <img width="350" src="https://github.com/user-attachments/assets/a5ccd7b5-4df8-406a-b3a8-80328ba210e5" />

1. Ative os pull requests clicando no botão **Pronto para Revisão** e depois clique no botão **Fazer merge**.

1. Com nossa revisão enviada e o pull request mesclado, Mona deve estar verificando nosso trabalho. Dê a ela um momento para responder com a próxima lição.

<details>
<summary>Tendo problemas? 🤷</summary><br/>

Se você não receber feedback, aqui estão algumas coisas para verificar:

- Certifique-se de que você fez commit das alterações no diretório `src/static/` para o branch `accelerate-with-copilot` e fez push/sincronizou com o GitHub.
- Se a Mona encontrou um erro, basta corrigir e enviar suas alterações novamente. A Mona verificará seu trabalho quantas vezes for necessário.

</details>

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

> [!DICA]
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

> [!DICA]
> Você pode usar o menu **edited** para ver o histórico de alterações da descrição do pull request.
>
> <details>
> <summary>Mostrar imagem</summary>
> <img width="500" alt="image" src="https://github.com/user-attachments/assets/cb88a67c-e42f-463c-88cd-b23a391b28a0" />
> </details>

### ⌨️ Activity: Provide Copilot feedback

1. Back in the pull request, click the **Add your review** button.

   <img width="350" src="https://github.com/user-attachments/assets/d71847b9-573b-451e-9c85-946a6988e3f0" />

1. Find the new entry created by Copilot. Hover over a line to show the plus sign. **Click** to open the add comment dialog box.

   <img width="350" src="https://github.com/user-attachments/assets/fd1375a4-fbdf-453e-a457-7bcb1fbbea23" />

1. Reading the description, we think it should be more interesting to match the Manga spirit. Let's ask Copilot to fix that. Enter the following text and click **Start a review**.

   ```md
   Please change this description to be inspired by Japanese Manga.
   It needs more personality to attract students.
   ```

   <img width="350" src="https://github.com/user-attachments/assets/f37da948-2062-4f46-ba75-bcff538800e4" />

1. At the top of the changes list, click the **Finish your review** button and select **Submit Review**.

1. After a moment, Copilot will add a new session entry and indicate progress on the timeline.

1. Wait for Copilot to finish working on the change and then click the **View changes** button to see the updated activity description.

   <img width="350" src="https://github.com/user-attachments/assets/a5ccd7b5-4df8-406a-b3a8-80328ba210e5" />

1. Activate the pull requests by clicking the **Ready to Review** button then click the **Merge** button.

1. With our review submitted and the pull request merged, Mona should be checking our work. Give her a moment to respond with the next lesson.

<details>
<summary>Having trouble? 🤷</summary><br/>

If you don't get feedback, here are some things to check:

- Make sure your commit the changes in the `src/static/` directory to the branch `accelerate-with-copilot` and pushed/synchronized to GitHub.
- If Mona found a mistake, simply make a correction and push your changes again. Mona will check your work as many times as needed.

</details>

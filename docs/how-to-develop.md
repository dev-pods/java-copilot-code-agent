# Guia de Desenvolvimento

## Configuração Inicial

Este projeto é melhor desenvolvido usando o GitHub Codespaces, que fornece um ambiente de desenvolvimento consistente com todas as ferramentas necessárias pré-configuradas.

### Configurando seu ambiente de desenvolvimento

1. Abra o repositório em um Codespace
2. Aguarde o container terminar de construir e instalar as dependências
3. Instale as dependências do Python executando:

   ```bash
   python -m pip install -r requirements.txt
   ```

### Dependências

O projeto requer os seguintes pacotes Python:

- FastAPI - Framework moderno para construção de APIs
- Uvicorn - Servidor ASGI para rodar a aplicação FastAPI

Essas dependências serão instaladas ao rodar `pip install -r requirements.txt`

## Depuração

### Executando o site localmente

1. No VS Code, acesse a visualização "Run and Debug" (Ctrl+Shift+D) e selecione "Launch Mergington WebApp" na lista de configurações
2. Pressione F5 ou clique no botão verde de play para iniciar a depuração
3. O site estará disponível em `http://localhost:8000`
4. A documentação da API estará disponível em `http://localhost:8000/docs`

### Dicas de depuração

- O recurso de auto-reload do FastAPI reiniciará automaticamente o servidor ao fazer alterações no código
- Use a documentação interativa da API em `/docs` para testar seus endpoints

## Primeiros Passos

1. Instale as dependências:

   ```bash
   pip install fastapi uvicorn
   ```

2. Execute a aplicação:

   ```bash
   python app.py
   ```

3. Abra seu navegador e acesse:
   - Documentação da API: http://localhost:8000/docs
   - Documentação alternativa: http://localhost:8000/redoc

## Uso

### Endpoints da API

| Method | Endpoint                                                          | Description                                                         |
| ------ | ----------------------------------------------------------------- | ------------------------------------------------------------------- |
| GET    | `/activities`                                                     | Get all activities with their details and current participant count |
| POST   | `/activities/{activity_name}/signup?email=student@mergington.edu` | Sign up for an activity                                             |

> [!IMPORTANT]
> All data is stored in memory, which means data will be reset when the server restarts.

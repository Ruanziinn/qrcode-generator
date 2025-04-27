# Gerador de QR Code

Uma aplicação Spring Boot que gera QR codes e os armazena no AWS S3. Este projeto demonstra a integração da biblioteca ZXing do Google para geração de QR code e do AWS S3 para armazenamento.

## Como usar

Esta seção fornece instruções abrangentes para configurar e executar o aplicativo Gerador de QR Code.

### Requisitos para rodar a aplicação

- Java 21 JDK
- Maven
- Docker
- AWS Account com acesso a S3
- AWS CLI configurada com credenciais apropriadas

## Environment Variables

Crie um arquivo `.env` na raíz do projeto com as seguintes variáveis:
``` 
AWS_ACCESS_KEY_ID=access_key
AWS_SECRET_ACCESS_KEY=secret_key
AWS_REGION=region
AWS_BUCKET_NAME=bucket_name
```
## Executando a aplicação

### Desenvolvimento Local

1. Clonar o repositório git
2. Crie o arquivo `.env` conforme descrito acima
3. Faça o build do projeto:
```
mvn clean package
```

4. Rode a aplicação
```
mvn spring-boot:run
```
Ou
```
java -jar qrcode-generator/target/qrcode-generator-0.0.1-SNAPSHOT.jar
```
### Deploy no Docker

1. Faça o build da imagem Docker
```
docker build -t qrcode-generator:X.X . 
```
Lembre-se de substituir a versão e o nome da imagem se desejar
2. Rodar o container 
```
docker run --env-file .env -p 8080:8080 qrcode-generator:X.X
```
Lembre-se de substituir o caminho do arquivo `.env` pelo caminho do arquivo de ambiente que você criou.

## Configuração AWS S3
1. Crie um bucket S3 na sua conta AWS
2. Atualize o `AWS_BUCKET_NAME` no seu arquivo `.env`
3. Certifique-se de que suas credenciais da AWS tenham permissões apropriadas para acessar o bucket S3

## API Endpoints
### POST /qrcode
Gera um QR Code a partir do texto fornecido e armazena-o no AWS S3. O QR Code será gerado como uma imagem PNG com dimensões de 200x200 pixels.

#### Parâmetros

|  Name   |   Required   |        Type         |                                                         Descrição                                                          |
|:-------:|:------------:|:-------------------:|:--------------------------------------------------------------------------------------------------------------------------:|
| `text`  | required | string  | O conteúdo textual a ser codificado no QR Code. Pode ser qualquer valor de string que você queira converter em um QR Code. | 

#### Response 
``` 
{
    "url": "https://your-bucket.s3.your-region.amazonaws.com/random-uuid"
}
```
#### Error Response
Se ocorrer um erro durante a geração do código QR ou o upload do S3, a API retornará um erro interno do servidor 500.

#### Exemplo de uso
```
curl -X POST http://localhost:8080/qrcode \
     -H "Content-Type: application/json" \
     -d '{"text": "https://example.com"}' 
```

#### A API poderá ser acessada em http://localhost:8080/qrcode.

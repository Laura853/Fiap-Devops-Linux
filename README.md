# CP2 — DevOps: Oracle VM + Docker + Spring Boot + MySQL

## 👤 Aluna
- **Nome:** Laura
- **RM:** 566376

## 🌐 Endpoint para Correção
Acesse no navegador: http://137.131.234.87:8080

## 📋 Rotas da API REST

| Método | Rota | Descrição |
|---|---|---|
| GET | /alunos | Lista todos os alunos |
| GET | /alunos/{id} | Busca aluno por ID |
| POST | /alunos | Cadastra novo aluno |
| PUT | /alunos/{id} | Atualiza aluno |
| DELETE | /alunos/{id} | Remove aluno |

## 🏗️ Arquitetura
- **Nuvem:** Oracle Cloud — Oracle Linux 9
- **Backend:** Java 17 + Spring Boot 3.2.4
- **Banco:** MySQL 8.0
- **Orquestração:** Docker Compose
- **Frontend:** HTML/CSS/JS servido pelo próprio Spring Boot

## 🚀 Como Executar em uma Nova VM

### Pré-requisitos
- VM com Ubuntu 22.04 ou Oracle Linux 9
- Porta 8080 aberta no firewall

### Passos
```bash
git clone https://github.com/Laura853/Fiap-Devops-Linux.git
cd Fiap-Devops-Linux
git checkout cp2-devops-docker
bash setup_vm.sh
```

Aguarde a mensagem `Started DemoApplication` nos logs:
```bash
sudo docker logs spring_app --follow
```

Acesse: `http://<IP-DA-VM>:8080`

# 📱 Leitor de QR Code de Produto (Android)

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Room](https://img.shields.io/badge/Jetpack_Room-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow?style=for-the-badge)

> Aplicativo Android para leitura eficiente de QR Codes e gerenciamento de produtos, com persistência de dados local.

---

## 📖 Sobre o Projeto

O **LeitorDeQrCodeDeProduto** é um aplicativo nativo Android desenvolvido em **Kotlin** que utiliza a câmera do dispositivo para escanear e decodificar QR Codes de produtos.

Diferente de leitores simples, este projeto integra o **Jetpack Room**, permitindo que os produtos escaneados sejam salvos em um banco de dados local no dispositivo, possibilitando consultas futuras e histórico de leituras, mesmo offline. A interface foi construída utilizando o sistema clássico de Views com **XML**.

## 🚀 Funcionalidades

* 📷 **Scanner Rápido:** Leitura ágil de QR Codes utilizando a biblioteca *CodeScan*.
* 💾 **Persistência de Dados:** Armazenamento automático dos produtos lidos utilizando **Room Database**.
* 📋 **Listagem de Produtos:** Visualização do histórico de itens escaneados.
* 🗑️ **Gerenciamento:** Opções para deletar ou organizar os registros salvos.
* 🎨 **Interface Intuitiva:** Layouts construídos em XML focados em usabilidade.

## 📱 Screenshots

| Tela Inicial | Scanner | Histórico |
|:---:|:---:|:---:|
| ![Home](https://via.placeholder.com/200x400?text=Home) | ![Scanner](https://via.placeholder.com/200x400?text=Scanner) | ![Historico](https://via.placeholder.com/200x400?text=List) |

*(Dica: Substitua os links acima por prints reais do seu aplicativo para valorizar o portfólio)*

## 🛠️ Tecnologias Utilizadas

* **[Kotlin](https://kotlinlang.org/):** Linguagem moderna e oficial para desenvolvimento Android.
* **[Android Studio](https://developer.android.com/studio):** IDE oficial utilizada no desenvolvimento.
* **[Jetpack Room](https://developer.android.com/training/data-storage/room):** Camada de abstração sobre o SQLite para persistência de dados robusta.
* **[CodeScan](https://github.com/yuriy-budiyev/code-scanner):** Biblioteca utilizada para a funcionalidade de leitura de códigos (assumindo *yuriy-budiyev/code-scanner* ou similar).
* **XML Layouts:** Construção de interface de usuário via View System.
* **Coroutines:** Para operações assíncronas de banco de dados (IO Dispatchers).

## ⚙️ Pré-requisitos

Para rodar o projeto, você precisará de:

1.  **Android Studio** (versão mais recente recomendada).
2.  Um dispositivo Android físico (recomendado para testar a câmera) ou Emulador.
3.  Cabo USB (para depuração em dispositivo físico).

## 🔧 Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/antoniojose2023/LeitorDeQrCodeDeProduto.git](https://github.com/antoniojose2023/LeitorDeQrCodeDeProduto.git)
    ```

2.  **Abra no Android Studio:**
    * Inicie o Android Studio.
    * Selecione "Open" e navegue até a pasta do projeto clonado.

3.  **Sincronize o Gradle:**
    * Aguarde o Android Studio baixar todas as dependências listadas no `build.gradle`.

4.  **Execute o App:**
    * Conecte seu celular ou inicie um emulador.
    * Clique no botão **Run** (ícone de Play verde) na barra superior.

> **Nota:** Se estiver usando um dispositivo físico, certifique-se de habilitar a "Depuração USB" nas opções de desenvolvedor do Android.

## 🤝 Contribuição

Sugestões e melhorias são bem-vindas!

1.  Faça um Fork do projeto.
2.  Crie uma Branch (`git checkout -b feature/NovaFeature`).
3.  Realize o Commit (`git commit -m 'Adiciona NovaFeature'`).
4.  Faça o Push (`git push origin feature/NovaFeature`).
5.  Abra um Pull Request.

## 📝 Licença

Este projeto é desenvolvido para fins de estudo e portfólio.
(Se desejar, adicione uma licença específica aqui, como MIT).

## 📞 Autor

**Antônio José**

* **GitHub:** [@antoniojose2023](https://github.com/antoniojose2023)
* **LinkedIn:** [Insira seu LinkedIn aqui](link-linkedin)

---
Desenvolvido com 💚 e Kotlin.

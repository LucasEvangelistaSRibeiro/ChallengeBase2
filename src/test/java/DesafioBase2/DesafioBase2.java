package DesafioBase2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioBase2 {

    @Test
    public void validaLoginIncorreto (){

        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker e verifica se o título corresponde ao esperado:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");
        Assert.assertEquals("MantisBT", driver.getTitle());

// Localiza os campos da tela de Login do site MantisBT sendo eles:"Username", "Password",
// checkbox "Remember", checkbox "Security", botão "Login" e o link "Lost your password?":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement remeberCheckbox = driver.findElement(By.name("perm_login"));
        WebElement securityCheckbox = driver.findElement(By.name("secure_session"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));
        WebElement linkLostPassword = driver.findElement(By.linkText("Lost your password?"));

// Preenche os campos "Username", "Password" e loga no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("testertester");
        loginButton.click();

// Localiza e valida mensagem de login incorreto, quando a senha e/ou usuário são incorretos ou não há preenchimento dos mesmos:
        WebElement passwordIncorrectText = driver.findElement(By.xpath("//font [@color = 'red']"));
        Assert.assertEquals("Your account may be disabled or blocked or the username/password you entered is incorrect.", passwordIncorrectText.getText());

    }

    @Test
    public void validaLoginCorreto (){
        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker e verifica se o título corresponde ao esperado:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");
        Assert.assertEquals("MantisBT", driver.getTitle());

// Localiza os campos da tela de Login do site MantisBT sendo eles:"Username", "Password",
// checkbox "Remember", checkbox "Security", botão "Login" e o link "Lost your password?":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement remeberCheckbox = driver.findElement(By.name("perm_login"));
        WebElement securityCheckbox = driver.findElement(By.name("secure_session"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));
        WebElement linkLostPassword = driver.findElement(By.linkText("Lost your password?"));

// Preenche os campos "Username", "Password" e loga no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("Tester-b@se2");
        loginButton.click();

// Localiza e valida o usuário logado:
        WebElement checkLoggedUser = driver.findElement(By.xpath("//td[@class = 'login-info-left']/span[@class = 'italic']"));
        Assert.assertEquals("Lucas.ribeiro", checkLoggedUser.getText());

    }

    @Test
    public void cadastraNovaOcorrenciaComSucesso (){
        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");

// Localiza os campos da tela de Login no site acessado:"Username", "Password" e o botão "Login":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

// Faz login no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("Tester-b@se2");
        loginButton.click();

// Localiza o link "Relatar Caso" e clica nele:
        WebElement linkRelatarCaso = driver.findElement(By.linkText("Relatar Caso"));
        linkRelatarCaso.click();

// Localiza e seleciona o combo "categoria":
        WebElement selectCategory = driver.findElement(By.name("category_id"));
        Select comboCategory = new Select(selectCategory);
        comboCategory.selectByIndex(5);

// Localiza e seleciona o combo "frequência":
        WebElement selectFrequency = driver.findElement(By.name("reproducibility"));
        Select comboFrequency = new Select(selectFrequency);
        comboFrequency.selectByIndex(5);

// Localiza e seleciona o combo "gravidade":
        WebElement selectGravity = driver.findElement(By.name("severity"));
        Select comboGravity = new Select(selectGravity);
        comboGravity.selectByIndex(7);

// Localiza e seleciona o combo "prioridade":
        WebElement selectPriority = driver.findElement(By.name("priority"));
        Select comboPriority = new Select(selectPriority);
        comboPriority.selectByIndex(5);

// Localiza e seleciona o combo "selecionar perfil":
        WebElement selectProfile = driver.findElement(By.name("profile_id"));
        Select comboProfile = new Select(selectProfile);
        comboProfile.selectByIndex(3);

// Localiza e preenche o campo "Plataforma":
        WebElement describePlatform = driver.findElement(By.id("platform"));
        describePlatform.sendKeys("Plataforma de Testes.");

// Localiza e preenche o campo "SO":
        WebElement describeSO = driver.findElement(By.id("os"));
        describeSO.sendKeys("Sistema Operacional de Testes.");

// Localiza e preenche o campo "Versão SO":
        WebElement describeVersionSO = driver.findElement(By.id("os_build"));
        describeVersionSO.sendKeys("Versão de Testes 1.0.");

// Localiza e preenche o campo "Resumo":
        WebElement writeResume = driver.findElement(By.name("summary"));
        writeResume.sendKeys("Resumo sobre o teste.");

// Localiza e preenche o campo "Descrição":
        WebElement writeDescription = driver.findElement(By.name("description"));
        writeDescription.sendKeys("Descrição do teste.");

// Localiza e preenche o campo "Passos para a Reprodução":
        WebElement writeStepsToReproduce = driver.findElement(By.name("steps_to_reproduce"));
        writeStepsToReproduce.sendKeys("Passo a passo para reproduzir o teste.");

// Localiza e preenche o campo "Informações Adicionais"
        WebElement writeAdditionalInfo = driver.findElement(By.name("additional_info"));
        writeAdditionalInfo.sendKeys("Informações adicionais sobre o teste.");

// Localiza o elemento botão "Escolher arquivo",:
        WebElement sendFile = driver.findElement(By.id("ufile[]"));

// Localiza os elementos radio buttons de visibilidade:
        WebElement markVisibilityPublic = driver.findElement(By.xpath("//input[@value = '10']"));
        WebElement markVisibilityPrivate = driver.findElement(By.xpath("//input[@value = '50']"));

// Localiza a checkbox "Continuar reportando":
        WebElement checkBoxKeepReporting = driver.findElement(By.id("report_stay"));

// Localiza e clica no button "Enviar Relatório":
        WebElement buttonSendReport = driver.findElement(By.xpath("//input[@value = 'Enviar Relatório']"));
        buttonSendReport.click();

// Localiza e valida mensagem de sucesso ao clicar em "Enviar Relatório":
        WebElement validaMensagemDeSucesso = driver.findElement(By.xpath("//div[@align='center'][contains(text(), 'Operação realizada com sucesso')][1]"));
//        Assert.a(driver.findElement(validaMensagemDeSucesso).getText());
        Assert.assertTrue(validaMensagemDeSucesso.equals("Operação realizada com sucesso."));
//        Assert.assertEquals("\n" +
//                "Operação realizada com sucesso.", validaMensagemDeSucesso.getText());

    }

    @Test
    public void cadastraNovaOcorrenciaSemCategoria (){
        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");

// Localiza os campos da tela de Login:"Username", "Password" e o botão "Login":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

// Faz login no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("Tester-b@se2");
        loginButton.click();

// Localiza o link "Relatar Caso" e clica nele:
        WebElement linkRelatarCaso = driver.findElement(By.linkText("Relatar Caso"));
        linkRelatarCaso.click();

// Localiza o combo "categoria":
        WebElement selectCategory = driver.findElement(By.name("category_id"));

// Localiza e seleciona o combo "frequência":
        WebElement selectFrequency = driver.findElement(By.name("reproducibility"));
        Select comboFrequency = new Select(selectFrequency);
        comboFrequency.selectByIndex(5);

// Localiza e seleciona o combo "gravidade":
        WebElement selectGravity = driver.findElement(By.name("severity"));
        Select comboGravity = new Select(selectGravity);
        comboGravity.selectByIndex(7);

// Localiza e seleciona o combo "prioridade":
        WebElement selectPriority = driver.findElement(By.name("priority"));
        Select comboPriority = new Select(selectPriority);
        comboPriority.selectByIndex(5);

// Localiza e seleciona o combo "selecionar perfil":
        WebElement selectProfile = driver.findElement(By.name("profile_id"));
        Select comboProfile = new Select(selectProfile);
        comboProfile.selectByIndex(3);

// Localiza e preenche o campo "Plataforma":
        WebElement describePlatform = driver.findElement(By.id("platform"));
        describePlatform.sendKeys("Plataforma de Testes.");

// Localiza e preenche o campo "SO":
        WebElement describeSO = driver.findElement(By.id("os"));
        describeSO.sendKeys("Sistema Operacional de Testes.");

// Localiza e preenche o campo "Versão SO":
        WebElement describeVersionSO = driver.findElement(By.id("os_build"));
        describeVersionSO.sendKeys("Versão de Testes 1.0.");

// Localiza e preenche o campo "Resumo":
        WebElement writeResume = driver.findElement(By.name("summary"));
        writeResume.sendKeys("Resumo sobre o teste.");

// Localiza e preenche o campo "Descrição":
        WebElement writeDescription = driver.findElement(By.name("description"));
        writeDescription.sendKeys("Descrição do teste.");

// Localiza e preenche o campo "Passos para a Reprodução":
        WebElement writeStepsToReproduce = driver.findElement(By.name("steps_to_reproduce"));
        writeStepsToReproduce.sendKeys("Passo a passo para reproduzir o teste.");

// Localiza e preenche o campo "Informações Adicionais"
        WebElement writeAdditionalInfo = driver.findElement(By.name("additional_info"));
        writeAdditionalInfo.sendKeys("Informações adicionais sobre o teste.");

// Localiza o elemento botão "Escolher arquivo",:
        WebElement sendFile = driver.findElement(By.id("ufile[]"));

// Localiza os elementos radio buttons de visibilidade:
        WebElement markVisibilityPublic = driver.findElement(By.xpath("//input[@value = '10']"));
        WebElement markVisibilityPrivate = driver.findElement(By.xpath("//input[@value = '50']"));

// Localiza a checkbox "Continuar reportando":
        WebElement checkBoxKeepReporting = driver.findElement(By.id("report_stay"));

// Localiza e clica no button "Enviar Relatório":
        WebElement buttonSendReport = driver.findElement(By.xpath("//input[@value = 'Enviar Relatório']"));
        buttonSendReport.click();

// Localiza e valida mensagem de erro clicar em "Enviar Relatório" e não ter selecionado a categoria:
        WebElement validaMesagemErroCategoria = driver.findElement(By.xpath("//p[@class='center'][contains(text(), 'Categoria')]"));
        Assert.assertEquals("Um campo necessário 'Categoria' estava vazio. Por favor, verifique novamente suas entradas.", validaMesagemErroCategoria.getText());

    }

    @Test
    public void cadastraNovaOcorrenciaSemResumo (){
        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");

// Localiza os campos da tela de Login:"Username", "Password" e o botão "Login":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

// Faz login no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("Tester-b@se2");
        loginButton.click();

// Localiza o link "Relatar Caso" e clica nele:
        WebElement linkRelatarCaso = driver.findElement(By.linkText("Relatar Caso"));
        linkRelatarCaso.click();

// Localiza e seleciona o combo "categoria":
        WebElement selectCategory = driver.findElement(By.name("category_id"));
        Select comboCategory = new Select(selectCategory);
        comboCategory.selectByIndex(5);

// Localiza e seleciona o combo "frequência":
        WebElement selectFrequency = driver.findElement(By.name("reproducibility"));
        Select comboFrequency = new Select(selectFrequency);
        comboFrequency.selectByIndex(5);

// Localiza e seleciona o combo "gravidade":
        WebElement selectGravity = driver.findElement(By.name("severity"));
        Select comboGravity = new Select(selectGravity);
        comboGravity.selectByIndex(7);

// Localiza e seleciona o combo "prioridade":
        WebElement selectPriority = driver.findElement(By.name("priority"));
        Select comboPriority = new Select(selectPriority);
        comboPriority.selectByIndex(5);

// Localiza e seleciona o combo "selecionar perfil":
        WebElement selectProfile = driver.findElement(By.name("profile_id"));
        Select comboProfile = new Select(selectProfile);
        comboProfile.selectByIndex(3);

// Localiza e preenche o campo "Plataforma":
        WebElement describePlatform = driver.findElement(By.id("platform"));
        describePlatform.sendKeys("Plataforma de Testes.");

// Localiza e preenche o campo "SO":
        WebElement describeSO = driver.findElement(By.id("os"));
        describeSO.sendKeys("Sistema Operacional de Testes.");

// Localiza e preenche o campo "Versão SO":
        WebElement describeVersionSO = driver.findElement(By.id("os_build"));
        describeVersionSO.sendKeys("Versão de Testes 1.0.");

// Localiza o campo "Resumo":
        WebElement writeResume = driver.findElement(By.name("summary"));

// Localiza e preenche o campo "Descrição":
        WebElement writeDescription = driver.findElement(By.name("description"));
        writeDescription.sendKeys("Descrição do teste.");

// Localiza e preenche o campo "Passos para a Reprodução":
        WebElement writeStepsToReproduce = driver.findElement(By.name("steps_to_reproduce"));
        writeStepsToReproduce.sendKeys("Passo a passo para reproduzir o teste.");

// Localiza e preenche o campo "Informações Adicionais"
        WebElement writeAdditionalInfo = driver.findElement(By.name("additional_info"));
        writeAdditionalInfo.sendKeys("Informações adicionais sobre o teste.");

// Localiza o elemento botão "Escolher arquivo",:
        WebElement sendFile = driver.findElement(By.id("ufile[]"));

// Localiza os elementos radio buttons de visibilidade:
        WebElement markVisibilityPublic = driver.findElement(By.xpath("//input[@value = '10']"));
        WebElement markVisibilityPrivate = driver.findElement(By.xpath("//input[@value = '50']"));

// Localiza a checkbox "Continuar reportando":
        WebElement checkBoxKeepReporting = driver.findElement(By.id("report_stay"));

// Localiza e clica no button "Enviar Relatório":
        WebElement buttonSendReport = driver.findElement(By.xpath("//input[@value = 'Enviar Relatório']"));
        buttonSendReport.click();

// Localiza e valida mensagem de erro clicar em "Enviar Relatório" e não ter preenchido o campo Resumo:
        WebElement validaMesagemErroResumo = driver.findElement(By.xpath("//p[@class='center'][contains(text(), 'Resumo')]"));
        Assert.assertEquals("Um campo necessário 'Resumo' estava vazio. Por favor, verifique novamente suas entradas.", validaMesagemErroResumo.getText());


    }

    @Test
    public void cadastraNovaOcorrenciaSemDescricao (){
        WebDriver driver = new ChromeDriver();

// Acessa o site Mantis Bug Tracker:
        driver.navigate().to("https://mantis-prova.base2.com.br/login_page.php");

// Localiza os campos da tela de Login:"Username", "Password" e o botão "Login":
        WebElement userField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));

// Faz login no site:
        userField.sendKeys("Lucas.ribeiro");
        passwordField.sendKeys("Tester-b@se2");
        loginButton.click();

// Localiza o link "Relatar Caso" e clica nele:
        WebElement linkRelatarCaso = driver.findElement(By.linkText("Relatar Caso"));
        linkRelatarCaso.click();

// Localiza e seleciona o combo "categoria":
        WebElement selectCategory = driver.findElement(By.name("category_id"));
        Select comboCategory = new Select(selectCategory);
        comboCategory.selectByIndex(5);

// Localiza e seleciona o combo "frequência":
        WebElement selectFrequency = driver.findElement(By.name("reproducibility"));
        Select comboFrequency = new Select(selectFrequency);
        comboFrequency.selectByIndex(5);

// Localiza e seleciona o combo "gravidade":
        WebElement selectGravity = driver.findElement(By.name("severity"));
        Select comboGravity = new Select(selectGravity);
        comboGravity.selectByIndex(7);

// Localiza e seleciona o combo "prioridade":
        WebElement selectPriority = driver.findElement(By.name("priority"));
        Select comboPriority = new Select(selectPriority);
        comboPriority.selectByIndex(5);

// Localiza e seleciona o combo "selecionar perfil":
        WebElement selectProfile = driver.findElement(By.name("profile_id"));
        Select comboProfile = new Select(selectProfile);
        comboProfile.selectByIndex(3);

// Localiza e preenche o campo "Plataforma":
        WebElement describePlatform = driver.findElement(By.id("platform"));
        describePlatform.sendKeys("Plataforma de Testes.");

// Localiza e preenche o campo "SO":
        WebElement describeSO = driver.findElement(By.id("os"));
        describeSO.sendKeys("Sistema Operacional de Testes.");

// Localiza e preenche o campo "Versão SO":
        WebElement describeVersionSO = driver.findElement(By.id("os_build"));
        describeVersionSO.sendKeys("Versão de Testes 1.0.");

// Localiza e preenche o campo "Resumo":
        WebElement writeResume = driver.findElement(By.name("summary"));
        writeResume.sendKeys("Resumo sobre o teste.");

// Localiza o campo "Descrição":
        WebElement writeDescription = driver.findElement(By.name("description"));

// Localiza e preenche o campo "Passos para a Reprodução":
        WebElement writeStepsToReproduce = driver.findElement(By.name("steps_to_reproduce"));
        writeStepsToReproduce.sendKeys("Passo a passo para reproduzir o teste.");

// Localiza e preenche o campo "Informações Adicionais"
        WebElement writeAdditionalInfo = driver.findElement(By.name("additional_info"));
        writeAdditionalInfo.sendKeys("Informações adicionais sobre o teste.");

// Localiza o elemento botão "Escolher arquivo",:
        WebElement sendFile = driver.findElement(By.id("ufile[]"));

// Localiza os elementos radio buttons de visibilidade:
        WebElement markVisibilityPublic = driver.findElement(By.xpath("//input[@value = '10']"));
        WebElement markVisibilityPrivate = driver.findElement(By.xpath("//input[@value = '50']"));

// Localiza a checkbox "Continuar reportando":
        WebElement checkBoxKeepReporting = driver.findElement(By.id("report_stay"));

// Localiza e clica no button "Enviar Relatório":
        WebElement buttonSendReport = driver.findElement(By.xpath("//input[@value = 'Enviar Relatório']"));
        buttonSendReport.click();

// Localiza e valida mensagem de erro  ao clicar em "Enviar Relatório" e não ter preenchido o campo Descrição:
        WebElement validaMesagemErroDescricao = driver.findElement(By.xpath("//p[@class='center'][contains(text(), 'Descrição')]"));
        Assert.assertEquals("Um campo necessário 'Descrição' estava vazio. Por favor, verifique novamente suas entradas.", validaMesagemErroDescricao.getText());

    }

}

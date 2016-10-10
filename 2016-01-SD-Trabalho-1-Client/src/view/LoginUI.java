/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.Console;
import view.menu.LoginMenu;

/**
 *
 * @author Cristiano
 */
public class LoginUI {

    public LoginUI() {
    }

    public long executar() {
        int opcao = 0;
        long idUsuario = -1;
        do {
            System.out.println(LoginMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case LoginMenu.OP_LOGIN:
                    idUsuario = efetuarLogin();
                    break;
                case LoginMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != LoginMenu.OP_VOLTAR);

        return idUsuario;
    }

    private long efetuarLogin() {
        long idUsuario = -1;

        String nomeUsuario = Console.scanString("Usuario: ");
        String senha = Console.scanString("Senha: ");
        System.out.println("Efetuando login...");
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        resource.Usuario usuario = port.buscarUsuario(nomeUsuario, senha);

        if (usuario != null) {
            System.out.println("Usuário [" + usuario.getNome() + "] logado.");
            idUsuario = usuario.getId();
        } else {
            System.out.println("Usuário não encontrado!");
        }

        return idUsuario;
    }

}

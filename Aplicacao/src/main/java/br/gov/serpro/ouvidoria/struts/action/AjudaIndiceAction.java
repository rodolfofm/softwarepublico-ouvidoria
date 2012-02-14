/*
 * Sistema de Ouvidoria: um canal através do qual os usuários
 * podem encaminhar suas reclamações, elogios e sugestões.
 * 
 * Copyright (C) 2011 SERPRO
 * 
 * Este programa é software livre; você pode redistribuí-lo e/ou
 * modificá-lo sob os termos da Licença Pública Geral GNU, conforme
 * publicada pela Free Software Foundation; tanto a versão 2 da
 * Licença como (a seu critério) qualquer versão mais nova.
 * 
 * Este programa é distribuído na expectativa de ser útil, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia implícita de
 * COMERCIALIZAÇÃO ou de ADEQUAÇÃO A QUALQUER PROPÓSITO EM
 * PARTICULAR. Consulte a Licença Pública Geral GNU para obter mais
 * detalhes.
 * 
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU,
 * sob o título "LICENCA.txt", junto com esse programa. Se não,
 * acesse o Portal do Software Público Brasileiro no endereço
 * http://www.softwarepublico.gov.br/ ou escreva para a Fundação do
 * Software Livre (FSF) Inc., 51 Franklin St, Fifth Floor, Boston,
 * MA 02111-1301, USA.
 * 
 * Contatos através do seguinte endereço internet:
 * http://www.serpro.gov.br/sistemaouvidoria/
 */
package br.gov.serpro.ouvidoria.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.gov.serpro.ouvidoria.controller.AjudaCtrl;
import br.gov.serpro.ouvidoria.controller.gerencial.administracao.FuncionarioCtrl;
import br.gov.serpro.ouvidoria.model.Ajuda;
import br.gov.serpro.ouvidoria.model.Funcionario;
import br.gov.serpro.ouvidoria.struts.ActionSupport;
import br.gov.serpro.ouvidoria.util.Constants;

/**
 * Exibir índice da ajuda para a funcionalidade em questão
 * 
 * @author SERPRO
 * @version $Revision: 1.1.2.4 $, $Date: 2011/10/20 15:30:36 $
 * @version 0.1, 2005/04/01
 */
public class AjudaIndiceAction extends ActionSupport {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // Recupera o Funcionário logado
    	
        Long funcionarioId = (Long) request.getSession().getAttribute(Constants.PA_FUNCIONARIO);
        
    	FuncionarioCtrl funcionarioCtrl = new FuncionarioCtrl(getDaoFactory());
    	
    	Funcionario funcionario = (Funcionario) funcionarioCtrl.get(funcionarioId);      	

        AjudaCtrl ajudaCtrl = new AjudaCtrl(getDaoFactory());

        request.setAttribute("lstAjuda", ajudaCtrl.consultaAjuda(funcionario,
                Ajuda.TIPO_INDICE));

        return mapping.findForward("success");
    }

}
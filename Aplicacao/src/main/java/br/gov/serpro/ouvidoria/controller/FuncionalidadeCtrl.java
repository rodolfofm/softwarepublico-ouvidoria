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
package br.gov.serpro.ouvidoria.controller;

import java.util.List;

import br.gov.serpro.ouvidoria.dao.Dao;
import br.gov.serpro.ouvidoria.dao.DaoException;
import br.gov.serpro.ouvidoria.dao.DaoFactory;
import br.gov.serpro.ouvidoria.model.Funcionalidade;

/**
 * Funcionalidade
 * 
 * Objetivo: Classe responsável pelos métodos de acesso a dados relacionados à
 * Funcionalidade
 * 
 * @author SERPRO
 * @version $Revision: 1.1.2.3 $, $Date: 2011/10/19 18:18:09 $
 * @version 0.1, Date: 2004/12/13
 */
public class FuncionalidadeCtrl {

	private Dao funcionalidadeDao;

	/**
	 * Construtor recebendo objeto Dao
	 * 
	 * @param daoFactory
	 */
	public FuncionalidadeCtrl(final DaoFactory daoFactory) {
		funcionalidadeDao = daoFactory.create(Funcionalidade.class);
	}

	/**
	 * Obtém a entidade à partir do ID recebido como parâmetro
	 * 
	 * @param id
	 * @return objeto da classe Ajuda
	 * @throws DaoException
	 */
	public Funcionalidade get(final Long id) throws DaoException {
		if (id == null) {
			throw new DaoException("ID do Objeto não pode ser nulo.");
		}
		return (Funcionalidade) funcionalidadeDao.get(id);
	}

	/**
	 * Método para listar os perfis
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List list() throws DaoException {
		return funcionalidadeDao.list();
	}

}
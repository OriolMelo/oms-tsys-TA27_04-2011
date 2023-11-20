package oms.UD27.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oms.UD27.dao.IInvestigadorDAO;
import oms.UD27.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService{
	@Autowired
	IInvestigadorDAO iInvestigadorDAO;

	@Override
	public List<Investigador> listarInvestigadores() {
		return iInvestigadorDAO.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public Investigador investigadorXID(String id) {
		return iInvestigadorDAO.findById(id).get();
	}

	@Override
	public Investigador actualizarInvestigador(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);
	}

	@Override
	public void eliminarInvestigador(String id) {
		iInvestigadorDAO.deleteById(id);
	}
}

package com.Hair2u.Hair2uApp.ui.principal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "O Salão de beleza Hair2U está no mercado da beleza há 7 anos, sua proprietária Susana Alves é especialista em micropigmentação, design de sobrancelhas e mega hair. Começou na área da beleza há mais de 20 anos e hoje ela quer expandir a sua empresa e para isso ela busca algumas ferramentas para facilitar a gestão do seu salão.\n" +
                "Com o aumento de serviços, produtos, clientes e colaboradores, ela deseja um sistema que auxilie nos serviços ofertados e no agendamento de horários online para dar mais conforto e agilidade para seus clientes. Busca na tecnologia encontrar soluções para esse novo desafio.\n" +
                "A empresa deseja que o sistema tenha o controle de cadastro de clientes, com o histórico de seu cliente e serviços que foram realizados, conta também com o controle de seus profissionais e serviços realizados com suas devidas comissões. Pensando em seus clientes a empresa deseja, através de seu site, fazer agendamentos online, podendo escolher o serviço, o profissional disponível ou indicado, na data e horário de sua preferência. \n"
    }
    val text: LiveData<String> = _text
}
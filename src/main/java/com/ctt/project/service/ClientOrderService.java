package com.ctt.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctt.project.dto.request.ClientOrderRequest;
import com.ctt.project.dto.response.ClientOrderResponse;
import com.ctt.project.entity.Client;
import com.ctt.project.entity.ClientOrder;
import com.ctt.project.entity.OrderStatus;
import com.ctt.project.entity.Payment;
import com.ctt.project.entity.PaymentStatus;
import com.ctt.project.entity.Product;
import com.ctt.project.repository.ClientOrderRepository;
import com.ctt.project.repository.ClientRepository;
import com.ctt.project.repository.OrderStatusRepository;
import com.ctt.project.repository.PaymentRepository;
import com.ctt.project.repository.ProductRepository;

@Service
public class ClientOrderService {

	@Autowired
	private ClientOrderRepository clientOrderRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ClientOrderResponse create (ClientOrderRequest clientOrderRequest) {
		//procurar o cliente com o valor igual ao informado no json
		Client client = this.clientRepository.findById(clientOrderRequest.getIdClient()).orElseThrow(RuntimeException::new);
       
		//regra para pagamento.
		
		//pegar da classe paymentStatus a situação do pedido atual
		//situação inicial do pedido deve estar como waiting
	    PaymentStatus paymentStatus = new PaymentStatus();
		String status = paymentStatus.WAITING;
		
		//pegar endereço do cliente
		String paymentProcessAddress = client.getAddress();
		
		String paymentType = clientOrderRequest.getPaymentType();
		
		Payment payment = new Payment(paymentProcessAddress, paymentType, status);
		
//		gravando um pagamento
		Payment paymentCreated = this.paymentRepository.save(payment);
		
//		regra para orderStatus
		OrderStatus orderStatus= new OrderStatus(status);
		OrderStatus orderStatusCreated = this.orderStatusRepository.save(orderStatus);
		
		ArrayList<Product> products = new ArrayList<>();
		for(int i =0; i < clientOrderRequest.getProducts().size(); i++) {
			products.add(this.productRepository.findById(clientOrderRequest.getProducts().get(i)).orElseThrow(RuntimeException::new));
		}
		
		ClientOrder clientOrder = new ClientOrder(clientOrderRequest, client, paymentCreated, orderStatusCreated, products);
		ClientOrder clientOrderCreated = this.clientOrderRepository.save(clientOrder);
		return new ClientOrderResponse(clientOrderCreated);
	}
}

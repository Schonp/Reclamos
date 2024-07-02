package com.reclamos.reclamos.services;

import com.reclamos.reclamos.model.Vecino;
import com.reclamos.reclamos.repositorios.VecinoRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegisterService {

    private final VecinoRepository vecinoRepository;
    private final JavaMailSender mailSender;

    public RegisterService(VecinoRepository vecinoRepository, JavaMailSender mailSender) {
        this.vecinoRepository = vecinoRepository;
        this.mailSender = mailSender;
    }

    public void registerVecino(Long documento, String nombre, String apellido, String direccion, String email) {
        String generatedPassword = generateRandomPassword();

        Vecino vecino = new Vecino();
        vecino.setDocumento(documento); // Asigna manualmente el documento
        vecino.setNombre(nombre);
        vecino.setApellido(apellido);
        vecino.setDireccion(direccion);
        vecino.setEmail(email);
        vecino.setPassword(generatedPassword);

        vecinoRepository.save(vecino);
        sendPasswordEmail(email, generatedPassword);
    }

    private String generateRandomPassword() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    private void sendPasswordEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your New Password");
        message.setText("Your password is: " + password);
        mailSender.send(message);
    }
}

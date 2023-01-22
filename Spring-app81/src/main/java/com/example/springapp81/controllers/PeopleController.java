package com.example.springapp81.controllers;

import com.example.springapp81.models.Person;
import com.example.springapp81.services.PersonService;
import com.example.springapp81.util.PersonErrorResponse;
import com.example.springapp81.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> allPeople() {
        return personService.allPeople();
    }

    @GetMapping("/{id}")
    public Person person(@PathVariable("id") int id) {
        return personService.person(id);
    }


    // Когда у нас выбрасывается исключение мы можем отправить специальный JSON с сообщением об ошибке.

    // Для этого есть специальная аннотация @ExceptionHandler.
    // Этой аннотацией мы помечаем тот метод, который, ловит исключение и возвращает необходимый JSON.

    // Создадим новый метод, он может быть приватным, потому что он для внутреннего использования. Он
    // будет обрабатывать исключения.
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        // В параметрах мы указываем, какое исключение мы будем ловить.

        // Также мы создаем Response - тот объект, который мы хотим вернуть человеку.
        PersonErrorResponse response = new PersonErrorResponse(
                // Тут мы кладем сообщение об ошибке и текущее время в мс.
                "Person with this id wasn't found",
                System.currentTimeMillis()
        );

        // Теперь этот объект нужно преобразовать в JSON и отправить по сети.
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        // NOT_FOUND так как у нашей ошибке статус 404 (страница не найдена).

        // ResponseEntity является оберткой над response, в котором мы кроме объекта можем указать статус
        // http-ответа.

        // Преобразование в JSON будет автоматически осуществляться.
    }
}

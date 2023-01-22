package com.example.springapp81.util;

// Чтобы этот класс был исключением нужно просто унаследоваться от RuntimeException.
public class PersonNotFoundException extends RuntimeException {

    // В этом классе будет сама ошибка. Будет выбрасываться исключение при ошибке.
    // Можно было выбрасывать просто какое-то общее исключение, но это неправильно.

}

package com.tms.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Описываем как настроить DispatcherServlet
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Эти два метода, в них мы передаем классы с настройками (на практике одинаково их вычитывает)
    // Настройки всего Spring?, этот метод возвращает массива классов конфигурации корневого контекста приложения
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // Этот метод возвращает массив классов конфигурации Dispatcher Servlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // Пути на которые Dispatcher Servlet должен отвечать, этот метод возвращает метод URL для DS
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // все что приходит на / будет обрабатывать
    }
}
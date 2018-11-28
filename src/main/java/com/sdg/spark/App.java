package com.sdg.spark;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;

public class App
{
    public static void main( String[] args ) {

        get("/", (req,res) -> {
            return new ModelAndView(null, "templates/index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

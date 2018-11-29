package com.sdg.spark;

import com.sdg.spark.model.CourseIdea;
import com.sdg.spark.model.CourseIdeaDAO;
import com.sdg.spark.model.NotFoundException;
import com.sdg.spark.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App
{
    public static void main( String[] args ) {
        staticFileLocation("/public");
        CourseIdeaDAO dao = new SimpleCourseIdeaDAO(); //PROTOTYPE: WOULD USUALLY USE A DATABASE

        before((req,res) -> {
            if (req.cookie("username") != null){
                req.attribute("username", req.cookie("username"));
            }
        });

        before("/ideas", (req,res) -> {
            //TODO:sdg - send message about the redirect
            if(req.attribute("username") == null){
                res.redirect("/");
                halt();
            }
        });

        get("/", (req,res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sign-in", (req,res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);
            res.redirect("/");
            return null; //hmmm
        });

        get("/ideas", (req,res) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("ideas", dao.findALL());
            return new ModelAndView(model,"ideas.hbs");
        },new HandlebarsTemplateEngine());

        post("/ideas", (req,res) ->{
            String title = req.queryParams("title");
            CourseIdea courseIdea = new CourseIdea(title, req.attribute("username"));
            dao.add(courseIdea);
            res.redirect("/ideas");
            return null; //hmmm
        });

        get("/ideas/:slug", (req,res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("idea", dao.findBySlug(req.params("slug")));
            return new ModelAndView(model, "idea.hbs");
        }, new HandlebarsTemplateEngine());

        post("/ideas/:slug/vote", (req,res) -> {
            CourseIdea idea = dao.findBySlug(req.params("slug"));
            idea.addVoter(req.attribute("username"));
            res.redirect("/ideas");
            return null;
        });

        exception(NotFoundException.class, (exc, req, res) -> {
            res.status(404);
            HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
            String html = engine.render(new ModelAndView(null, "not-found.hbs"));
            res.body(html);
        });


    }
}

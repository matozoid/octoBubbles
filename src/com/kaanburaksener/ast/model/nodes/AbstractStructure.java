package com.kaanburaksener.ast.model.nodes;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.kaanburaksener.octoUML.src.model.nodes.AbstractNode;

import java.util.List;

/**
 * Created by kaanburaksener on 16/02/17.
 */
public class AbstractStructure {
    private static final String type = "ABSTRACT";
    private AbstractNode refNode;
    private List<Modifier> accessModifiers;
    private String name;
    private String path;
    private CompilationUnit compilationUnit;

    public AbstractStructure(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public AbstractNode getRefNode() {
        return refNode;
    }

    public void setRefNode(AbstractNode refNode) {
        this.refNode = refNode;
    }

    public List<Modifier> getAccessModifiers() {
        return accessModifiers;
    }

    public void setAccessModifiers(List<Modifier> accessModifiers) {
        this.accessModifiers = accessModifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }

    public void setCompilationUnit(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public double calculateHeight() {
        int totalNumberOfLine = compilationUnit.getRange().get().end.line;
        double coefficient = 20.0;

        double total = totalNumberOfLine * coefficient;

        if(total > 450.0) {
            total = 450.0;
        }

        return total;
    }

    public void printStructure() {
        System.out.print("Modifiers: ");
        accessModifiers.stream().forEach(am-> {
                System.out.print(am + " ");
        });
        System.out.println(", name: " + name + ", path: " + path);
        System.out.println();
        System.out.println(compilationUnit.toString());
        System.out.println();
    }
}

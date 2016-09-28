new GroovyShell().parse(new File('./src/it/integration_tests.groovy')).with {

    child       = parse(basedir, 'pom.xml')
    parent  = parse(basedir, 'project-parent/pom.xml')
    aggregate = parse(basedir, 'project-aggregate-pom/pom.xml')

    expect parent.version,              "1.0-SNAPSHOT", "version of parent POM"
    expect child.parent.version,  "1.0-SNAPSHOT", "version of parent POM referenced from project parent POM"
    expect child.version, "1.0-2", "version of child POM"
    expect aggregate.parent.version, "1.0-SNAPSHOT", "version of parent POM referenced from aggregate POM"
}

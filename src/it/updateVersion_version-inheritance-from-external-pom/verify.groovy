new GroovyShell().parse(new File('./src/it/integration_tests.groovy')).with {

    child  = parse(basedir, 'pom.xml')

    expect child.parent.version, "1.4.1.RELEASE", "version of parent POM referenced from child POM"
    expect child.version, "1.0-2", "version of child POM"
}

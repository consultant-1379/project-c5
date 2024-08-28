package com.cloudnative.cnmm;

import com.cloudnative.cnmm.data.models.question.Answer;
import com.cloudnative.cnmm.data.models.question.Question;
import com.cloudnative.cnmm.data.models.question.QuestionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialConfiguration {

    private QuestionRepository repo;

    private final String[] categories = {
            "CULTURE",
            "PRODUCT/SERVICE DESIGN",
            "TEAM",
            "PROCESS",
            "ARCHITECTURE",
            "MAINTENANCE AND OPERATIONS",
            "DELIVERY",
            "PROVISIONING",
            "INFRASTRUCTURE"
    };

    private final String[] primaries = {
            "Do you have a collaborative culture (e.g. big but not specific/highly detailed goals with no fixed delivery dates)?",
            "Is you product and design data driven – that is they are rapidly prototyped, deployed and evaluated based on real customer usage before deciding on further development or retirement)",
            "Are teams Devops teams that is self contained teams responsible for all development anddeployment to production and production is monitored by SRE teams?",
            "Do you use research and experimentation techniques for large and complex problems - using lots of proof of concepts to compare options, using Kanban to clarify the project then Agile methods like Scrum once problem is well understood?",
            "Do you have a microprocessor architecture built from independently deployable services?",
            "Does your system collect metrics, alerts tracing and logging to provide a view of the running system and try to keep itself alive through self healing if things begin to deteriorate?",
            "Do you deliver multiple times a day your releasable software?",
            "Do you run on Kubernetes?",
            "Do you deploy your software in containers?"
    };

    private final String[] secondaries = {
            "How individuals in your organisation interact, communicate, and work with each other.",
            "What you do, and how you go about doing it. How do decisions get made in your organisation about new products to build, or services and features to offer — or how to improve existing ones? ",
            "How do responsibilities, communication, and collaboration work between teams in your organisation?",
            "How do you plan and then execute work?",
            "What is the overall structure of your technology and systems?",
            "How does your organisation deploy software and run it in production?",
            "How does software progress from your development teams to running live in production?",
            "How does your organisation create and then control new infrastructure? How quickly can you deploy?",
            "Your Infrastructure describes the physical servers or instances that your production environment consists of: what they are, where they are, and how they are managed."
    };

    private final Answer[] answers = {
            new Answer("Project managers coordinate between all the different\n" +
                    "teams working on the same project, and the teams have\n" +
                    "highly specialised responsibilities.", 2),
            new Answer("Our development teams focus on achieving small,\n" +
                    "defined objectives quickly and then moving immediately\n" +
                    "to the next one.", 3),
            new Answer("A lot of up-front planning goes into documenting each\n" +
                    "step of a project before it even begins.", 2),
            new Answer("Each team contain a mix of members whose different\n" +
                    "areas of expertise cover the full spectrum of skills needed\n" +
                    "for crafting a releasable increment.", 3),
            new Answer("We have product roadmaps spanning months or even\n" +
                    "years into the future. Our releases typically happen every\n" +
                    "six months to one year, sometimes even longer", 2),
            new Answer("There is pressure to deliver features, fast, and releases\n" +
                    "happen on a regular planned basis. (For example, ‘We’ll\n" +
                    "Feature X in two months, Feature Y in four months and\n" +
                    "Feature Z in six months’—with no deviation from the\n" +
                    "schedule)", 3),
            new Answer("We release large sets of related features all at once as\n" +
                    "comprehensive updates.", 2),
            new Answer("Our releases are usually small-scale iterative changes to\n" +
                    "existing features/services.", 3),
            new Answer("All decisions are made by managers, and teams must\n" +
                    "seek permission before changing any part of the project\n" +
                    "plan, no matter how small.", 2),
            new Answer("Applications are developed as several large components,\n" +
                    "with one team per component fully and vertically\n" +
                    "responsible for the build.", 3),
            new Answer("We have separate teams of specialists to handle different\n" +
                    "areas: design, architecture, security, testing, etc. When\n" +
                    "our team’s piece of a project is finished, we hand it off to\n" +
                    "the next team.", 2),
            new Answer("Our teams are mixed: We have developers, QA/testing,\n" +
                    "someone with server experience, etc. all in one group. We\n" +
                    "don’t talk to other teams very much since our teams are\n" +
                    "meant to be self-sufficient and independent.", 3),
            new Answer("We do all our planning up front, and then hand off to\n" +
                    "teams for execution. Managers handle the collaboration\n" +
                    "and communication between our teams.", 2),
            new Answer("A team will work on one small, defined project and deliver\n" +
                    "it in two to four weeks. If a new feature request comes in\n" +
                    "the middle of a delivery cycle, we may or may not be able\n" +
                    "to add it in.", 3),
            new Answer("If a new feature request comes in the middle of a delivery\n" +
                    "cycle, we have to wait for the next cycle to plan for and\n" +
                    "incorporate it.", 2),
            new Answer("If we can’t coordinate or fix an issue on the last day or two\n" +
                    "of a production cycle, we can’t ship—so when a bug or\n" +
                    "some other problem pops up it’s hard to do anything more\n" +
                    "than a quick fix. (Following up to address an issue in more\n" +
                    "depth requires a dedicated sprint so we can focus on it).", 3),
            new Answer("Our system is very big. Few people understand the\n" +
                    "whole thing. We fear the domino effect: If you change\n" +
                    "something, you have to be very careful because it could\n" +
                    "break something else.", 2),
            new Answer("Our application(s) is(are) divided into components,\n" +
                    "probably no more than five or six, communicating through\n" +
                    "networking.", 3),
            new Answer("When we deliver, everything is delivered together, all\n" +
                    "ready on the same day and at a uniformly high level of\n" +
                    "quality.", 2),
            new Answer("The scope of an app in development is defined by\n" +
                    "the deployment schedule. Each feature or piece of\n" +
                    "functionality is broken down into deliverable chunks that\n" +
                    "fit into the schedule.", 3),
            new Answer("We have some simple automation, like scripts, for alerting\n" +
                    "large-scale issues and outages in the field. We find out\n" +
                    "about many smaller problems from user reports.", 2),
            new Answer("Our systems have full and continuous monitoring, and our\n" +
                    "Ops team spends lots of time checking on alerts. A lot of\n" +
                    "time, our system alerts turn out to be nothing.", 3),
            new Answer("When problems arise, we have to open each server to\n" +
                    "understand what happened because we don’t have central\n" +
                    "logs or tracing. Then we fix it manually: someone from\n" +
                    "Operations logs into a production server and follows a\n" +
                    "preset procedure.", 2),
            new Answer("Some of our system update processes are fully automated\n" +
                    "and patches can be applied quickly—but a human still has\n" +
                    "to initialise the process.", 3),
            new Answer("We do ‘big bang’ releases that roll lots of changes into\n" +
                    "one new version, every six to 12 months. A lot of up-front\n" +
                    "planning goes into our next release before any actual\n" +
                    "development begins.", 2),
            new Answer("Our delivery process includes some test automation\n" +
                    "and automated build, but outside of final integration.\n" +
                    "In an emergency, we can make manual updates to the\n" +
                    "production codebase.", 3),
            new Answer("We don’t like to make changes to our production code,\n" +
                    "even emergency ones, because there are so many\n" +
                    "dependencies. Change is risky. Once we release a software\n" +
                    "version all changes have to wait for the next version roll out.", 2),
            new Answer("New functionality requests typically can be\n" +
                    "accommodated within a few weeks, if they are urgent.", 3),
            new Answer("Operations team is in charge of provisioning, period. You\n" +
                    "have to write a ticket to provision a machine—engineers\n" +
                    "can’t self-service.", 2),
            new Answer("A machine can be provisioned (possibly even\n" +
                    "autoprovisioned) in hours, or maybe a day or two, and the\n" +
                    "process is fully automated by Ops.", 3),
            new Answer("Developers write applications, and specify what they\n" +
                    "will need to run successfully in production (OS, libraries,\n" +
                    "dependent tools). The Ops team manually configures the\n" +
                    "production machines to meet the machine dependencies\n" +
                    "the Dev team specified.", 2),
            new Answer("Provisioning is a mix of automation and manual work.\n" +
                    "Any task taking longer than a week to provision to VM\n" +
                    "breaks the production cycle, so is a nonstarter.", 3),
            new Answer("We have multiple physical servers in our own private\n" +
                    "data center (either on premises or co-located). If one of\n" +
                    "our servers goes down, we have to manually provision its\n" +
                    "replacement.", 2),
            new Answer("We don’t use physical servers—we have VMs. We also\n" +
                    "have some instances in the cloud, which we manage\n" +
                    "manually.", 3),
            new Answer("A data centre failure is just about the worst disaster we\n" +
                    "can imagine.", 2),
            new Answer("Provisioning infrastructure is a mix of automation and\n" +
                    "manual work, so a new VM can take a couple of days to\n" +
                    "set up.", 3)
    };

    public InitialConfiguration(QuestionRepository repo) {
        this.repo = repo;
        createQuestions();
    }

    public void createQuestions() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Question q = new Question();
            q.setPrimary(primaries[i]);
            q.setSecondary(secondaries[i]);
            q.setNumber(i + 1);
            q.setCategory(categories[i]);
            q.setAnswers(Arrays.asList(answers[i*4], answers[(i*4) + 1], answers[(i*4) + 2], answers[(i*4) + 3]));
            questions.add(q);
        }
        repo.saveAll(questions);
    }


}

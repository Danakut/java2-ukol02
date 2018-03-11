package cz.czechitas.webapp.controller;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import jdk.nashorn.internal.objects.annotations.*;

@Controller

public class Ukol02Controller {

    private static final List<String> TEXTY = Arrays.asList(
            "I'm lending you my personal airship to get to Amnoon. Keep it in one piece. Heard you don't have the best track record with 'em. | Captain Ellen Kiel",
    "Best of luck, Commander. It's a powder keg over there, and that maniac has already lit the fuse. | Captain Ellen Kiel",
    "Heading for the desert, Commander? Swordmaster Faren, Lord of Beetletun, is ready! Let chaos-bringers and quaggan-kickers alike beware! | Lord Faren",
    "Faren, my friend, never call someone who's about to cross the ocean \"chum\". | Catrine Evenstead",
    "That's why I love this town: even our leaders live by the rule \"it's easier to get forgiveness than permission\" | Sheriff Turma",
    "I can't believe one of the gods we worship, one of the Six, just... gave up on us. Doesn't care. It... doesn't feel right. | Lady Kasmeer Meade",
    "A council actually making a practical and timely desicion? Call the town crier - this has to be a first. | Rytlock Brimstone",
    "You've build a marvelous casino, Zalambur. My troops have been enjoying it. And now they will enjoy razing it to the ground. | Archon Iberu",
    "I'm full of unwise ideas. But protecting the living from an undead army isn't one of them. | Catrine Evenstead",
    "I still hear the screams - I ran when it started, and... Oh, Dwayna forgive me. I'm a coward. I should've died with them. |  a refugee near Amnoon",
            "It's a madhouse in the lab now. They're giving tours. Tours! Ugh. | Taimi",
            "While my freedom's been gratifying, it's also a little boring. This is much more interesting. Besides, I may have made a wager that the slayer of Elder Dragons can take down a god - and I intend to collect. | Canach",
            "These people aren't warriors. Unlike you, they see challenging a god as certain death. So they prefer to run... and live. | Shadows Agent Kito",
            "I always knew this \"human/god\" dynamic was a disaster to happen. | Canach",
            "Stop. Why fight over blame when we can end this thing now and fight over credit? | Catrine Evenstead",
            "I feel trapped in this role... in this \"legacy\". I yearn for freedom, but I cannot turn away from these responsibilities. To do so would doom the mortal races to certain destruction. And perhaps myself as well. But then again... there is a kind of freedom in death, is there not? | Vlast",
            "The task is done. Now, let us all imagine Balthazar red-faced and frustrated over his failure to stop us. | Canach",
            "Sadly, Vlast matured in isolation. We didn't know how to socialize him properly until it was too late. By the time we realized Vlast needed to bond with mortal races as Glint had, he no longer could... nor cared to. | Sadizi",
            "Liar! All who take breatch know me! I am King Joko the Inevitable, the last Primeval King, Joko the Undying, the Scourge of Vabbi. Joko the Feared, Joko the Beloved, Joko the Eternal Monarch of All. How dare you claim to not know who I am! | Palawa Joko",
            "I was deceived by the fallen god Balthazar. I led him here to claim spirits for his army. In exchange, I was promised a share of his new recruits. But he betrayed me and stranded me here instead. Perfidy! From now on, the only god I trust is me. | Palawa Joko",
            "Some gods just need to have their immortality revoked. | Lady Kasmeer Meade",
            "Leading a borrowed army of corpses into battle against the god of war? Wish I'd known this was your plan when I bet on you at the casino. | Canach",
            "You think before you guys pack up and head home you could maybe do something about those pesky sand sharks? They're the worst | an Amnoon noble",
            "For the last time, I am not a grouchy cactus man. Nor am I a giant talking choya. You urchins have the manners of a fifthborn. | Canach",
            "It's embarrassing to think that Dragon's Watch has been reduced to dragon babysitting. | Rytlock Brimstone",
            "Now that you've convinced them the world is in absolutely no danger... Why not join us outside so we can figure out how to keep it from exploding into a million pieces? | Canach",
            "We're clearly winning here, so why aren't they losing? | Rytlock Brimstone",
            "... Ha! Kablam! I mean: first field test of Scruffy's new tactical upgrades, successful. And look, I brought Agent Kito! | Taimi",
            "Joko? I died valiantly, a worthy end, only to be raised from the dead by that infernal sop! Turned into this! Compelled to obey his every order! I banished myself here to evade them. Can't obey what you can't hear. | Awakened Koss Dejarin",
            "The Dejarin line lives to fight another day! Thank you for that news. To know they went on to live their lives, have children, grandchildren... If I weren't so ... dead, it'd warm my heart. | Awakened Koss Dejarin",
            "Whatever you just did, it turned off the gate. Do it again. | Braham Eirsson",
            "I've been better. It's not every day you're almost asphyxiated by your own golem. But I'll live. | Taimi",
            "You people have history books? Open any one of 'em and it'll tell you: short-term gains bring long-term trouble. | Rytlock Brimstone",
            "Free people of Amnoon, a fellow citizen needs your help! Talib asks your help rounding up sand-shark pups that escaped his exotic animal ranch. Until the pups can be recovered, protect your toes when crossing the sands. | Herald Kehnan",
            "Wonderful, just wonderful! Seems like old times... All that's missing from this experience is a good, old-fashioned hydra attack. That's how I ended up here. Never saw it coming... | Pahan the ghost",
            "Yeah, I couldn't pay my taxes once. Got me killed. On the plus side, that led to this great job. | Awakened Caster tax collector",
            "Pathetic. You fail even as a distraction. | Warden Jabari",
            "Welcome to Augury's Shadow, home to the Followers of Ascension. Xunn is searching for Forgotten glyphs, Dawnwynn cuts down Branded, and Adisa collects Slivers of Vlast for my smithing. | Follower Lucius Anvilblade",
            "Where'd all my carrots go? Did those jerks take 'em again? Who thinks hiding carrots is funny? | Stablemaster Unja",
            "Groundhogs! They ruin my fields. They ruin my crops. They ruin my shoes. If you ever have an enemy, wish groundhogs on them. There's nothing worse. | Azmer",
            "What season is it? I feel like I should be pulling out the holiday decorations, but I’m not sure which holiday it is. | Primeval Servant ghost",
            "Conscientious subjects of Palawa Joko's empire enhance productivity by multitasking while taking breaks. | Awakened Affirmation System",
            "At the end of every day, be sure to ask yourself, \"Would I be more productive if I was no longer living?\" | Awakened Affirmation System",
            "Congratulations. King Joko rewards your adequate performance of today's tasks by allowing you to perform them again tomorrow. | Awakened Affirmation System",
            "Your benevolent king has awakened the sun for another fine day under his unerring rule. Praise Joko.  | Awakened Affirmation System",
            "Rest assured this announcement service will only be used during sleep hours if there is an important message to relay. | Awakened Affirmation System",
            "Another day dawns thanks to the generosity of your divine leader Palawa Joko. You’re welcome. | Awakened Affirmation System",
            "A good night’s rest revitalizes your waking work for the king. Night shift and Awakened, report immediately or be punished. | Awakened Affirmation System",
            "The sun has risen today thanks to your benevolent lord Palawa Joko. Praise be. | Awakened Affirmation System",
            "Ask yourself: Were all my actions today for the betterment of Elona? If not, please report to the Mordant Crescent. | Awakened Affirmation System",
            "Good morning, Vabbians. May the rising sun evoke the brilliant enduring ascent of your divine king Palawa Joko. | Awakened Affirmation System",
            "King Palawa Joko, father of the United Kingdom of Elona, accepts your collective nightly well-wishes, spoken or implied. | Awakened Affirmation System",
            "Should the first light of this day be your last, rest easy in the knowledge you’ll be Awakened in the name of Palawa Joko. | Awakened Affirmation System",
            "Welcome to Vehjin. Please consider my palace, your palace. And if there is anything I can do for you, you need only ask with a bit of bowing and scraping. | Prince Bakkal",
            "I've worn the same pants for nine days straight! Oh. I'm...not sure why I'm saying that out loud. | Elonian Royal",
            "I've formed a plan to defeat the Forged. I just need acorns. Lots and lots of acorns.  | Elonian Royal"
            );

    
    @RequestMapping("/novyindex.html")
    public ModelAndView zobrazStranku() {
        ModelAndView drzakNaDataAJmenoStranky;
        drzakNaDataAJmenoStranky = new ModelAndView("Ukol02-template");

        Random generatorNahodnychCisel = new Random();
        int cisloTextu = generatorNahodnychCisel.nextInt(TEXTY.size());

        String text = TEXTY.get(cisloTextu);
        int delitko = text.indexOf("|");
        String citace = new String ("\"");
        citace += text.substring(0, delitko);
        citace += "\"";
        String autor = new String ("- ");
        autor += text.substring(delitko+1);
        
        drzakNaDataAJmenoStranky.addObject("citace", citace);
        drzakNaDataAJmenoStranky.addObject("autor", autor);
       
        return drzakNaDataAJmenoStranky;
    }
}

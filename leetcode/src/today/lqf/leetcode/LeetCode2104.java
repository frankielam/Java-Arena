package today.lqf.leetcode;

/**
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 *
 */
public class LeetCode2104 {

    // 超时算法
    public long subArrayRanges2(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        long rst = 0;
        int cnt = 0;

        for (int i = 2; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                int n = i;
                long min = nums[j], max = nums[j];
                int m = j + 1;
                while (n-- > 1) {
                    if (nums[m] < min) {
                        min = nums[m];
                    } else if (nums[m] > max) {
                        max = nums[m];
                    }
                    m++;
//                    n--;
                    cnt++;
                }
                rst += max - min;
            }

        }
        System.out.println(cnt);
        return rst;
    }

    // 优化算法
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        long rst = 0;
        int cnt = 0;

        for (int i = 0; i <= len - 2; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i+1; j < len; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                } else if (nums[j] > max) {
                    max = nums[j];
                }
                rst += max - min;
                cnt++;
            }
        }

        System.out.println(cnt);
        return rst;
    }

    public static void main(String[] args) {
        LeetCode2104 obj = new LeetCode2104();
//        System.out.println(obj.subArrayRanges(new int[] { 1, 2, 3 }));
//        System.out.println(obj.subArrayRanges(new int[] { 1, 3, 3 }));
//        System.out.println(obj.subArrayRanges(new int[] { 4, -2, -3, 4, 1 }));
//        System.out.println(obj.subArrayRanges(new int[] { -31372, 86677, 70463, 37727, -91683, -41347, -90576, -82174,
//                -84198, -5148, -12591, -34156, 49770, 9666, -77075, -57678, -31101, -47531, -86306, -91337, -89507,
//                -24917, -87692, -39171, 98075, 17787, -42549, 34352, -70752, 71832, 70055, -1026, 3784, 2190, -36669,
//                959, 50619, 97129, 77088, 54049, 51707, 72052, 59230, -96834, -14048, -9619, 84853, 99362, 69885, 74086,
//                -28737, 23060, -63323, 13156, -72998, 94336, -75409, 58266, -86800, -54564, 80773, 40687, -47207, 43609,
//                -56556, 21192, -48024, -58907, 1629, -65561, -68397, 31862, -2201, -34966, 43542, -59201, -3637, -21936,
//                -93559, 49435, 23249, -54299, 70508, -90795, -3620, -33894, 43927, 10208, -7390, 86931, 48175, 81859,
//                95058, -16614, 38066, -99361, 63621, -99285, -47111, 29933, 73901, 60455, 46586, -84117, 35256, -89853,
//                33383, -91662, 82979, -48835, -93877, -80929, -98904, -47773, 69451, 85183, -14449, -51496, 75765,
//                35062, 12456, 35254, -16363, 80792, -3414, 9244, 62961, -52057, 56344, -50277, -26870, -63323, 54993,
//                75596, -93637, -78526, -3058, -30560, 82233, -50795, -5290, -641, -83040, 13524, 86725, 23735, 29280,
//                43938, -43995, -8992, -83717, -62090, 74538, 58682, -56550, -8638, 61528, -87974 }));
        // subArrayRanges2 计算 106,009,190 次
        // subArrayRanges  计算     369,370 次
        System.out.println(obj.subArrayRanges2(new int[] { 213429218, -187618039, -331715015, -905755625, -346941533,
                -792583612, 990659396, 302500324, 174167078, -739480009, -417233632, 444717314, -786175411, 704336570,
                -478147235, -916834396, 571975174, -688950235, -896721456, 93040074, 108445790, 553866495, -866180865,
                -179625145, 621189610, -161713899, 997871566, 998242645, -910535855, 811939049, 270354875, 126360366,
                966882132, 119499020, 141892872, -246146966, 733676120, 454534770, -772181828, -609718446, 988800907,
                672446771, -690698159, 261630728, 27489071, -782021736, 109626056, 782159592, 136538222, -206615307,
                -761477881, -883298790, 259740084, 717698000, -419538166, 52277426, 616402638, -596682413, 409248768,
                580831038, 825138020, 738976660, -305398038, 105076640, -684346167, 346506239, -648089329, 94786850,
                104881784, 885051714, 652051398, -560959222, 398756444, 475825253, -681948326, 272601766, -452276835,
                130728797, 8846982, -220320642, 459532191, 248238638, 558353296, -579003795, -373080291, 291463982,
                906653801, -740248122, 893493317, 825828018, 118088865, 882663224, 682044539, 302876021, 966715739,
                -147006922, 459911211, -101004062, -398903200, 917128802, 237030306, 332680353, -890994851, 275001625,
                460757365, 531236955, 588215582, 260246749, 275167813, -358246060, 123405760, -880158890, 383335840,
                -91547422, 27222427, -851288050, -471518975, 294157741, 502426910, -289204375, -502496862, 278465176,
                -474613960, 29421227, -843879900, 989775791, 942391363, -28374937, -704573732, -257734430, -178388589,
                66925202, 606781962, 467626710, 443348917, -665401176, 806158394, 759488024, 870142729, -330673125,
                -225847631, -253447870, 779346965, 579359852, -542994812, -365396516, -231378703, -105980967,
                -198627865, 304502781, -14168295, -237563481, -620366714, -561883320, 944577642, -255493711, 300505333,
                -799621330, 236975427, -225964016, -796377587, 628583136, 309544297, -814692997, 571444664, -568504649,
                128718976, -318639452, -307126678, -488925921, -514305688, -376562685, 185251106, -441595325, 856364245,
                643518871, -788100382, -88381304, 591758600, 52571857, 407158655, 78674634, 130139002, 466901224,
                592857630, 302184174, 364617882, -771250617, 768594470, -987621079, 955092079, -948391595, 223612996,
                862581501, -535584907, -180304934, 68627066, 72843029, 683992714, 201836837, -940422864, -488651504,
                288181748, -289267136, 378728447, 89529597, 539831960, -188025476, 412949798, -712330453, 537701470,
                -45683036, -572736581, 135001762, 351126624, 274534559, -339885144, 732306087, 642841632, -611673079,
                723312065, -359050113, -27610220, 822110970, -449380589, 963901010, 119853699, 326735157, -95692959,
                -531042260, -963044328, 996339138, 313086533, -545270797, 742086156, 282212315, 284398055, 657988755,
                473558247, -452617574, 867086476, -223980415, 291805989, -916697744, 360729819, 242949212, -694928555,
                -792188235, -655829472, -431080529, -573507746, -478636503, 604455894, 235889111, -928572959,
                -966319884, 462242008, 655957579, -631955106, 579728836, -984209386, 147271472, 212163512, -176341760,
                -76660193, 98714693, 632377526, -502594786, 715040239, 904008225, 228603727, -551280566, -546621863,
                -583596037, -203559188, 458675702, 416416471, -913594800, -708711249, -399056352, -627608851, 894690634,
                301486922, -634034296, 910917360, -843415910, -687819438, 827689947, 690413169, -401513277, 795407221,
                -729943996, 934565716, -361087018, 899637400, -253986759, -176944712, -565998170, 748051262, -926956464,
                -945737363, 991449190, -346785743, -247331443, -243658215, -118324148, 760442737, 843769181, -679688320,
                534762260, 365487795, -700092102, 484186154, 978895876, -179361103, 922585622, -155508868, 755204071,
                842285296, -732897015, -595658052, -978038325, 133592235, 599719104, 315930200, -988536951, 394579336,
                -796542066, -494618052, 852392493, 123138517, 106150881, -581798568, 912070007, 763635547, 184383529,
                208851517, 17542294, 517594951, 791319772, 138658301, -746620130, -418733244, 85662217, 33528432,
                740977071, 460714810, -947713727, -638327328, -346511735, 908997218, 198245762, 936119237, 763346042,
                927819643, -252322888, -443624283, 436390089, -988911068, 537393937, 258335447, -408326982, -170907571,
                -233299223, -687114041, 458043726, 734745077, -722941984, -127852917, 510034176, 400305938, 139171488,
                -178787053, -247215990, 72711912, -325765696, -955734912, -841254999, -999767941, 894021485, 307042873,
                -890504149, 130586741, 305927449, -593431843, 438827891, -968966455, 955240120, -737173881, -216513509,
                -704715498, 492063086, 51622091, -245571812, -756840247, -649044389, -381023631, -574936420, -181532168,
                -116487, 44886134, -286532275, -744142947, -568263399, -404568632, -796282649, 889645166, 456888550,
                -383897176, 249532502, 280557434, 186716068, -705388821, 439042206, -835494525, 733220617, 912019145,
                -396003898, 134436100, 618202879, -810383255, 545734866, -35493512, -65654224, 487938367, -490817855,
                -856860017, -88329408, 433976841, 38541489, 86058802, -956745999, -656449373, 964124857, -621338330,
                -23774468, -439322850, 267589640, -636549517, -89775847, -337324170, 603501472, -504544902, -409557992,
                -461389051, 269427987, -611721969, -769353867, -450152186, 749200730, 185285492, 855131557, 886908882,
                33735210, 650426864, 656555706, -178803275, -90913069, 496897924, -346913760, 200358869, 219388973,
                -746684988, 711767872, -770057674, 144392349, -487467724, -432044717, 230022661, -543005578, -400975262,
                352830137, -245968750, -851222093, -732450338, -378986726, -286139894, 44776155, 668929231, 127603792,
                -735977718, -357489967, -615966793, 860820248, 594311487, -477688725, 76583845, -160209600, -607534322,
                750890927, 422128359, 346718262, -965447079, 102271581, -638891424, -883204043, 790154345, 781252985,
                951580356, -226686631, 890055550, -502789026, 565700523, -652702850, -357497689, -530373006, -478779274,
                -724482244, 552573172, -508604610, 86861191, -485843653, 229940975, -303656407, 40355365, -443136841,
                -962452250, -406607296, 510504517, 710347844, 210468015, 765203823, 40794399, -132871752, -615522934,
                290917971, -990048311, -505593302, 375882859, -963084037, -523760636, -175010965, 224929064, -504689856,
                -374724051, 455028659, 744372436, 833851920, -611699541, 170181679, -825430265, 943013302, 385095529,
                898454914, 216143532, 114671596, 841598294, 623942163, -658116691, -357410862, 496750929, 815396607,
                397682320, 699782302, 962169560, -977207168, 418474322, 109579818, 239791248, -486036877, 273535227,
                901841534, 9891880, -892706212, -204990558, -476087623, -382605212, 484832177, 516165868, -232522864,
                -120611868, -417956312, -36893058, -738032002, -831476505, -495350451, 482933702, -356379112,
                -326548757, -517201907, -354074732, 929715575, 351778147, 53028940, -644537882, -682770046, 677451953,
                -684897898, 440967780, -431105542, -283489868, -386868435, 758145420, -63954902, -542969713, -282265518,
                -923497394, -419928457, -61347884, 300108895, -352052726, 787229286, 262325572, 160166475, 731620744,
                -301155322, 318954075, 740791171, -647444288, -180801419, -151871193, -593728671, -171274834,
                -701523097, 974023498, -504989887, -625660651, -57807641, -464722714, 321717165, -23863916, 598653872,
                -670441701, -713791051, 548008289, -895992465, 485643562, -142344007, -619586655, 718226037, 841880125,
                364403438, 383318069, -394271327, -706654974, -97379081, -718188733, -143768279, 507863577, -571113113,
                -511387155, -115896366, 224416757, -944440986, -547175115, 53899365, -815274160, -678058481, 363096953,
                -118522502, -882444665, 874009620, -789663090, 893823561, 955729229, -279191119, 587984567, 63368589,
                543872734, -344680683, 323764014, 605043823, 468536426, 415287622, -963866045, -898288620, -964067454,
                -98757453, 362413515, -820944649, 365121712, 340351479, 430348097, 202814717, 36705812, 354220687,
                796899229, 38491001, -832656461, 575939108, 813350070, 801458944, 281756266, -37324586, 628515040,
                917839620, 860026803, -660534362, 41733408, 113603927, -730183660, -898932043, -527342394, 558669674,
                658747998, 803013169, 801367342, -399223805, -715190276, -854752457, -333578332, -587319217, -88274359,
                -380350207, -289214625, -395893169, -460800007, -717587774, -204877380, -468046066, 673700925,
                -539993050, 681849574, 393494783, 630410905, 521820793, -773962749, 529808939, 793959818, 540427725,
                -264937175, -640971768, -837167366, -383736142, 976557760, 830613396, -735229383, -780907050, 709656383,
                957547761, -943071763, -273543879, -148808409, 831831971, -969243462, -561693385, -570923082, 628229512,
                633986520, 659419373, 64227141, 481249926, 710403803, 846385571, 227477326, -515769577, 913812768,
                467033435, 166933892, 324428304, 374941031, 812077547, -458469354, -915655835, 178599968, 745910857,
                902408858, 676018224, -569677074, 926289704, -865604499, 49370581, -257189643, -451386735, -537186662,
                -453355056, 74838442, 425781164, -393450132, 273491763, 227084338, -610324607, 351699841, -137601258,
                -52196548, -665791601, 573880713, 408981326, 599413253, 445208845, -238323271, -410443832, 944266667,
                125939240, 296255527, -67117770, 739802015, -746517038, 123580614, -775998127, 188416396, 169649128,
                -520659874, 36194873, 696865155, -172244787, 357436165, 814350316, 512084983, -105385570, 669269904,
                -948543192, -539795632, -969637248, 546033223, -359829768, 481497605, 374853574, -836486686, -276082050,
                -488166037, -889111825, 396249996, -492354610, -566309362, -760173172, 628457284, -632263536,
                -361007027, 349053367, 798435002, 751673025, 343049576, 700380289, 351463175, 744138911, -827885983,
                -615756386, 278300695, 924336822, -818753654, 598410200, 621336923, 492268074, -48324603, 948273477,
                737275298, -684752651, -325886131, 554276393, 462736427, -350383443, 63501867, 2080246, 901905610,
                -199164262, 180779078, 99012315, -308391935, 891090584, -34505660, -6528512, -51111845, 334150305,
                -860152218, -393129746, -874600676, 346489654, -110734235, 587620457 }));
    }

}

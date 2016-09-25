package com.github.triploit.npp5.other;

import com.github.triploit.npp5.compiler.LCompiler;

public class CompileCode
{
	private LCompiler lc;
	
	public CompileCode(String code)
	{
		 lc = new LCompiler(code);
	}
	
	public void setCode(String c)
	{
		lc.setCode(c);
	}
	
	public void initStrings()
	{
		lc.addString("mov",    "_0d8dnBK34tv3vq3b2b673753nbzgu7hj5gftrJd9d8dgbaksj");
		lc.addString("add",    "_dmwjl4345trz55t6zeruzez5t4r65rzk88zbw67ard7gb");
		lc.addString("defi",   "_bf0nefbrvbv3bq3v39q4teufrz44z8urwiefhzu423");
		lc.addString("defs",   "_zuhefie8978tgzruhfwjioc98f7t67f2gehuded7f878zhui");
		lc.addString("div",    "_fr234e44rtt32rtw43egz5hrwe4tzuisa8u7r1e2dq2rr12");
		lc.addString("leq",    "_qr123ot687z8u6t7zd45rsw35setrhzdtjuzfq3fq");
		lc.addString("geq",    "_2qf2r6u7t6i85674e63wa5erfht6u7e4fq2r2");
		lc.addString("eq",     "_9vq3rn0v903vb7vn3bvnr373vqvrvqn37vz0v980203vn");
		lc.addString("neq",    "_q2tg28jwfjpfapr90b0xdfcgbjzu7t65e4df3gerh");
		lc.addString("mod",    "_wafawfz678dgtrfh7zugfr6z5ezh4w3eftjna");
		lc.addString("mul",    "_z234t62t65rsdfxbgnjzu5retrsgf43gfbhw2");
		lc.addString("div",    "_5u7z62wrdhgfhjzuztaegsxfcgnvhgkzuiwht3rf3e");
		lc.addString("ddv",    "_dft5rh5zhfndgtsefdsgvbdhzte5345derhzzwz34");
		lc.addString("ddm",    "_6w344r3wz8nh8bb8vhnzvrp3thtio4tr5gzfs2");
		lc.addString("inp",    "_3tgfez54647zw5zh4f89sber8fz8oe7zr9p8webr6u556tg");
		lc.addString("end",    "_09naw9d6wabaw9f7wa67jf09n0h280eiiwovbhnui");
		lc.addString("prv",    "_436z73qweh4bvr78tzqw7896v837b59u735e6uhrz");
		lc.addString("rem",    "_45zhgwe43e5v6h2983rb9q2vn9b29v79q2vnz6ue54ez");
		lc.addString("gt", 	   "_w467z54hg3e22er0vrqn9z3rfb0jqvnvh705b47z345hzu");
		lc.addString("return", "_345zrer3hnvrq89vr7nq0236bvnqp902nv2zzu46565i5z");
		lc.addString("[n]",    "_89w7anq22vnq2v9070q29vnq2b9bn9v2btrvfqpu9f8235rfw5");
		lc.addString("say",    "_fn8e7ff0t7eg8zegvf8uhijfq5bh0ntzf0rfuj98n8fna8w");
		lc.addString(";",      "_fn0awnf7qd89vqhr8nfuinz070u9fzqr0ß7rfv209afa89wf9na");
		lc.addString("@",      "_n0af798qnzbmß908nzthjof0uq3u8hjtgf90awfba90w7bf0");
		lc.addString("{",      "_0nf7a9wq2rdfqrnzfh9m00ßm7qß7zhmfqtzbf9awnfß0aw8f9");
		lc.addString("}",      "_w70fa7nwq2rfzhvuoqm0jb74rhnzq09n8v8z88f9a0ßwfn0aw79b");
		lc.addString(" ",      "_nw0faqrfvnzm9q087rnfzh0viihdgztn0wf60fn7a90w7fn");
		lc.addString("\"",     "_2w3e45r5qrwfnz9e8r7gt83nvrg9097mt6zi7ri5u8etj");
		lc.addString(",",      "_w3zu487wzrfnqz98t89q7nbu9rzq78zhsrjrk44zu5hj5i");
		
		/*lc.addString("A", "_3bv98rh0qnpv2b12787z6t5frhzuji87zuih90nrh8n90bv7rn3");
		lc.addString("E", "_q2r7nzu90mjj45io0pobhzgt6z7890iopkjk2ß6z3q90v03nr0r9389n");
		lc.addString("I", "_66g4w89u98u9f0uh89u394tz8i907z87uiuhuzguztzre3ui");
		lc.addString("O", "_e3d4rf5tg6hzjukilopo9kki8ju7hzbgtvfvrcvrgh6j7zu89o");
		lc.addString("U", "_45rtfhzuji876u5trfgd5rtzui8976tzuihjgftz7654et76zu8ihjgtz76");
		lc.addString("R", "_893gb88fz4864guqr9203g3r9qrp3hg3zrqp0247fn895gbth8");
		lc.addString("L", "_efzuhivvnh0qvznq390bgrqnevhwunh75h29z84n9t4z90q3bwe4");
		lc.addString("G", "_fe07gu9rqwh76fn0qmßwhz4tbqh4vokouifnu6305ribt84z");
		lc.addString("H", "_54uzhe4gbt2q23rwebg35tnb345bt4n6j53q5tnj5hrq3h5g");
		lc.addString("S", "_3h35th4erdthgw4gert656454werdftzmju765h4gerwf5ju6");

		/*lc.addString("A", " 01 ");
		lc.addString("a", " 02 ");
		
		lc.addString("B", " 03 ");
		lc.addString("b", " 04 ");
		
		lc.addString("C", " 05 ");
		lc.addString("c", " 06 ");
		
		lc.addString("D", " 07 ");
		lc.addString("d", " 08 ");
		
		lc.addString("E", " 09 ");
		lc.addString("e", " 0A ");
		
		lc.addString("F", " 0B ");
		lc.addString("f", " 0C ");
		
		lc.addString("G", " 0D ");
		lc.addString("g", " 0E ");
		
		lc.addString("I", " 0F ");
		lc.addString("i", " A1 ");
		
		lc.addString("J", " A2 ");
		lc.addString("j", " A3 ");
		
		lc.addString("K", " A4 ");
		lc.addString("k", " A5 ");
		
		lc.addString("L", " A6 ");
		lc.addString("l", " A7 ");
		
		lc.addString("M", " A8 ");
		lc.addString("m", " A9 ");
		
		lc.addString("N", " AA ");
		lc.addString("n", " AB ");
		
		lc.addString("O", " AC ");
		lc.addString("o", " AD ");
		
		lc.addString("P", " AE ");
		lc.addString("p", " AF ");
		
		lc.addString("Q", " B1 ");
		lc.addString("q", " B2 ");
		
		lc.addString("R", " B3 ");
		lc.addString("r", " B4 ");
		
		lc.addString("S", " B5 ");
		lc.addString("s", " B6 ");
		
		lc.addString("T", " B7 ");
		lc.addString("t", " B8 ");
		
		lc.addString("U", " B9 ");
		lc.addString("u", " BA ");
		
		lc.addString("V", " BC ");
		lc.addString("v", " BD ");
		
		lc.addString("W", " BE ");
		lc.addString("w", " BF ");
		
		lc.addString("X", " C1 ");
		lc.addString("x", " C2 ");
		
		lc.addString("Y", " C3 ");
		lc.addString("y", " C4 ");
		
		lc.addString("Z", " C5 ");
		lc.addString("z", " C6 ");
		
		lc.addString("H", " C7 ");
		lc.addString("h", " C8 ");
		
		lc.addString(";", " C9 ");
		lc.addString(":", " CA ");
		
		lc.addString("\"", " CB ");
		lc.addString("\'", " CD ");
		
		lc.addString(".", " CE ");
		lc.addString(",", " CF ");
		
		lc.addString(" ", " D1 ");
		lc.addString("_", " D2 ");
		
		lc.addString("-", " D3 ");
		lc.addString(" ", " D4 ");
		lc.addString("\t", " D5 ");
		
		lc.addString("#", " D6 ");
		lc.addString("+", " D7 ");
		
		lc.addString("*", " D8 ");
		lc.addString("/", " D9 ");
		lc.addString("\\", " DA ");
		
		lc.addString("?", " DB ");
		lc.addString("!", " DC ");
		
		lc.addString("§", " DE ");
		lc.addString("$", " DD ");
		lc.addString("%&", " DF ");
		
		lc.addString(")", " E1 ");
		lc.addString("(", " E2 ");
		
		lc.addString("=", " E3 ");
		
		lc.addString("}", " E4 ");
		lc.addString("[", " E5 ");
		
		lc.addString("{", " E6 ");
		lc.addString("]", " E7 ");
		
		lc.addString("~", " E8 ");
		lc.addString("<", " E9 ");
		lc.addString(">", " EA ");
		lc.addString("|", " EB ");
		
		lc.addString("0", " EC ");
		lc.addString("@", " ED ");
		lc.addString("E", " EF ");*/
		
		/*lc.addString("", "EG ");
		lc.addString("", "F1 ");
		lc.addString("", "F2 ");
		lc.addString("", "F3 ");*/
	}
	
	public LCompiler getCompiler()
	{
		return lc;
	}
	
	public String decryptCode()
	{
		return lc.doDecrypt();
	}
	
	public String encryptCode()
	{
		return lc.doEncrypt();
	}
}

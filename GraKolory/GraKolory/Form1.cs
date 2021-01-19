using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GraKolory
{
    public partial class Form1 : Form
    {
        Random random;
        int zielone = 0;
        int czerwone = 0;
        int punkty = 0;
        const int MAX_CZAS = 10;
        int czas = MAX_CZAS;
        bool graTrwa = false;
        public Form1()
        {
            InitializeComponent();
            random = new Random();
            label2.Text = punkty.ToString();
            label1.Text = czas.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            timer_animacja.Start();
            timer_czas.Start();
            graTrwa = true;
            punkty = 0;
            czas = MAX_CZAS;
            label3.Visible = false;
            panel5.Visible = false;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            int x;
            panel1.BackColor = Color.LightGray;
            panel2.BackColor = Color.LightGray;
            panel3.BackColor = Color.LightGray;
            panel4.BackColor = Color.LightGray;

            do
            {
                x = random.Next(1, 5);
            } while (x == zielone);
            czerwone = x;

            do
            {
                x = random.Next(1, 5);
            } while (x == zielone || x==czerwone);
            zielone = x;

            switch (czerwone)
            {
                case 1: panel1.BackColor = Color.Red; break;
                case 2: panel2.BackColor = Color.Red; break;
                case 3: panel3.BackColor = Color.Red; break;
                case 4: panel4.BackColor = Color.Red; break;
            }
            switch (zielone)
            {
                case 1: panel1.BackColor = Color.Green; break;
                case 2: panel2.BackColor = Color.Green; break;
                case 3: panel3.BackColor = Color.Green; break;
                case 4: panel4.BackColor = Color.Green; break;
            }
            timer_punkty.Stop();
            
        }



        private void panel1_MouseHover(object sender, EventArgs e)
        {
            if (zielone==1 && graTrwa) 
                timer_punkty.Start();
        }

        private void timer_punkty_Tick(object sender, EventArgs e)
        {
            punkty++;
            label2.Text = punkty.ToString();
        }

        private void panel2_MouseHover(object sender, EventArgs e)
        {
            if (zielone == 2 && graTrwa)
                timer_punkty.Start();
        }

        private void panel3_MouseHover(object sender, EventArgs e)
        {
            if (zielone == 3 && graTrwa)
                timer_punkty.Start();
        }

        private void panel4_MouseHover(object sender, EventArgs e)
        {
            if (zielone == 4 && graTrwa)
                timer_punkty.Start();
        }

        private void timer_czas_Tick(object sender, EventArgs e)
        {
            czas--;
            if (czas <= 0) gameOver();
            label1.Text = czas.ToString();
        }

        private void gameOver()
        {
            graTrwa = false;
            timer_animacja.Stop();
            timer_czas.Stop();
            timer_punkty.Stop();
            panel5.Visible = true;
            label3.Visible = true;
        }

        private void panel1_MouseEnter(object sender, EventArgs e)
        {
            if (czerwone == 1 && graTrwa)
                gameOver();
        }

        private void panel2_MouseEnter(object sender, EventArgs e)
        {
            if (czerwone == 2 && graTrwa)
                gameOver();
        }

        private void panel3_MouseEnter(object sender, EventArgs e)
        {
            if (czerwone == 3 && graTrwa)
                gameOver();
        }

        private void panel4_MouseEnter(object sender, EventArgs e)
        {
            if (czerwone == 4 && graTrwa)
                gameOver();
        }
    }
}

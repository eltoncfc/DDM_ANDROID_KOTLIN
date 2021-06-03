package br.com.hair2u.hair2uapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProfissionalAdapter (
    val profissional: List<Profissional>,
    val onclick: (Profissional) -> Unit
    ) : RecyclerView.Adapter<ProfissionalAdapter.ProfissionalViewHolder>() {

    class  ProfissionalViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProcess: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProcess = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_profissional)
        }
    }

    override fun getItemCount()  = this.profissional.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfissionalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_profissional, parent, false)
        val holder = ProfissionalViewHolder(view)
        return  holder
    }

    override fun onBindViewHolder(holder: ProfissionalViewHolder, position: Int) {
        val profissionais = this.profissional[position]

        holder.cardNome.text = profissionais.nome
        holder.cardProcess.visibility = View.VISIBLE

        val contexto = holder.itemView.context


        Picasso.with(contexto).load(profissionais.foto).fit().into(holder.cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProcess.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProcess.visibility = View.GONE
                    /*holder.cardImg.setImageResource(R.drawable.cab)*/
                }
            }
        )

        holder.itemView.setOnClickListener { onclick(profissionais) }


    }

}
